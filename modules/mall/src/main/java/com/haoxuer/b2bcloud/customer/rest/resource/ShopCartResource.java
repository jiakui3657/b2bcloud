package com.haoxuer.b2bcloud.customer.rest.resource;

import com.haoxuer.b2bcloud.customer.api.apis.ShopCartApi;
import com.haoxuer.b2bcloud.customer.api.domain.list.ShopCartList;
import com.haoxuer.b2bcloud.customer.api.domain.page.ShopCartPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.ShopCartResponse;
import com.haoxuer.b2bcloud.customer.data.dao.ShopCartDao;
import com.haoxuer.b2bcloud.customer.data.entity.ShopCart;
import com.haoxuer.b2bcloud.customer.rest.conver.ShopCartResponseConver;
import com.haoxuer.b2bcloud.customer.rest.conver.ShopCartSimpleConver;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.haoxuer.bigworld.member.rest.conver.PageableConver;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class ShopCartResource implements ShopCartApi {

    @Autowired
    private ShopCartDao dataDao;

    @Override
    public ShopCartResponse create(ShopCartCreateRequest request) {
        ShopCartResponse result = new ShopCartResponse();

        ShopCart bean = new ShopCart();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new ShopCartResponseConver().conver(bean);
        return result;
    }

    @Override
    public ShopCartResponse update(ShopCartUpdateRequest request) {
        ShopCartResponse result = new ShopCartResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        ShopCart bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new ShopCartResponseConver().conver(bean);
        return result;
    }

    private void handleData(ShopCartCreateRequest request, ShopCart bean) {
        bean.setNum(request.getNum());
    }

    @Override
    public ShopCartResponse delete(ShopCartViewRequest request) {
        ShopCartResponse result = new ShopCartResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(),request.getId());
        return result;
    }

    @Override
    public ShopCartResponse view(ShopCartViewRequest request) {
        ShopCartResponse result=new ShopCartResponse();
        ShopCart bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new ShopCartResponseConver().conver(bean);
        return result;
    }
    @Override
    public ShopCartList list(ShopCartListRequest request) {
        ShopCartList result = new ShopCartList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<ShopCart> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new ShopCartSimpleConver());
        return result;
    }

    @Override
    public ShopCartPage search(ShopCartSearchRequest request) {
        ShopCartPage result=new ShopCartPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<ShopCart> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new ShopCartSimpleConver());
        return result;
    }
}
