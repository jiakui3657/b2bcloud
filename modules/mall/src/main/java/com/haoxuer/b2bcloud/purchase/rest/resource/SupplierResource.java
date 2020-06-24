package com.haoxuer.b2bcloud.purchase.rest.resource;

import com.haoxuer.b2bcloud.purchase.api.apis.SupplierApi;
import com.haoxuer.b2bcloud.purchase.api.domain.list.SupplierList;
import com.haoxuer.b2bcloud.purchase.api.domain.page.SupplierPage;
import com.haoxuer.b2bcloud.purchase.api.domain.request.*;
import com.haoxuer.b2bcloud.purchase.api.domain.response.SupplierResponse;
import com.haoxuer.b2bcloud.purchase.data.dao.SupplierDao;
import com.haoxuer.b2bcloud.purchase.data.entity.Supplier;
import com.haoxuer.b2bcloud.purchase.rest.conver.SupplierResponseConver;
import com.haoxuer.b2bcloud.purchase.rest.conver.SupplierSimpleConver;
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
public class SupplierResource implements SupplierApi {

    @Autowired
    private SupplierDao dataDao;

    @Override
    public SupplierResponse create(SupplierCreateRequest request) {
        SupplierResponse result = new SupplierResponse();

        Supplier bean = new Supplier();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new SupplierResponseConver().conver(bean);
        return result;
    }

    @Override
    public SupplierResponse update(SupplierUpdateRequest request) {
        SupplierResponse result = new SupplierResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Supplier bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new SupplierResponseConver().conver(bean);
        return result;
    }

    private void handleData(SupplierCreateRequest request, Supplier bean) {
        bean.setShop(request.getShop());
        bean.setNote(request.getNote());
        bean.setAddress(request.getAddress());
        bean.setLng(request.getLng());
        bean.setPhone(request.getPhone());
        bean.setName(request.getName());
        bean.setTel(request.getTel());
        bean.setLat(request.getLat());
    }

    @Override
    public SupplierResponse delete(SupplierViewRequest request) {
        SupplierResponse result = new SupplierResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(),request.getId());
        return result;
    }

    @Override
    public SupplierResponse view(SupplierViewRequest request) {
        SupplierResponse result=new SupplierResponse();
        Supplier bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new SupplierResponseConver().conver(bean);
        return result;
    }
    @Override
    public SupplierList list(SupplierListRequest request) {
        SupplierList result = new SupplierList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.desc("id"));
        List<Supplier> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new SupplierSimpleConver());
        return result;
    }

    @Override
    public SupplierPage search(SupplierSearchRequest request) {
        SupplierPage result=new SupplierPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<Supplier> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new SupplierSimpleConver());
        return result;
    }
}
