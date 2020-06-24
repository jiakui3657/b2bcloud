package com.haoxuer.b2bcloud.promote.rest.resource;

import com.haoxuer.b2bcloud.promote.api.apis.CouponApi;
import com.haoxuer.b2bcloud.promote.api.domain.list.CouponList;
import com.haoxuer.b2bcloud.promote.api.domain.page.CouponPage;
import com.haoxuer.b2bcloud.promote.api.domain.request.*;
import com.haoxuer.b2bcloud.promote.api.domain.response.CouponResponse;
import com.haoxuer.b2bcloud.promote.data.dao.CouponDao;
import com.haoxuer.b2bcloud.promote.data.entity.Coupon;
import com.haoxuer.b2bcloud.promote.rest.conver.CouponResponseConver;
import com.haoxuer.b2bcloud.promote.rest.conver.CouponSimpleConver;
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
public class CouponResource implements CouponApi {

    @Autowired
    private CouponDao dataDao;

    @Override
    public CouponResponse create(CouponCreateRequest request) {
        CouponResponse result = new CouponResponse();

        Coupon bean = new Coupon();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new CouponResponseConver().conver(bean);
        return result;
    }

    @Override
    public CouponResponse update(CouponUpdateRequest request) {
        CouponResponse result = new CouponResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Coupon bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new CouponResponseConver().conver(bean);
        return result;
    }

    private void handleData(CouponCreateRequest request, Coupon bean) {
        if (StringUtil.isNotEmpty(request.getName())) {
            bean.setName(request.getName().trim());
        }
    }

    @Override
    public CouponResponse delete(CouponDeleteRequest request) {
        CouponResponse result = new CouponResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(),request.getId());
        return result;
    }

    @Override
    public CouponResponse view(ViewRequest request) {
        CouponResponse result=new CouponResponse();
        Coupon bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new CouponResponseConver().conver(bean);
        return result;
    }
    @Override
    public CouponList list(CouponListRequest request) {
        CouponList result = new CouponList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<Coupon> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new CouponSimpleConver());
        return result;
    }

    @Override
    public CouponPage search(CouponSearchRequest request) {
        CouponPage result=new CouponPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        Page<Coupon> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new CouponSimpleConver());
        return result;
    }
}
