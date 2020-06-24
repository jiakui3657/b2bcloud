package com.haoxuer.b2bcloud.promote.rest.resource;

import com.haoxuer.b2bcloud.promote.api.apis.PromoteApi;
import com.haoxuer.b2bcloud.promote.api.domain.list.PromoteList;
import com.haoxuer.b2bcloud.promote.api.domain.page.PromotePage;
import com.haoxuer.b2bcloud.promote.api.domain.request.*;
import com.haoxuer.b2bcloud.promote.api.domain.response.PromoteResponse;
import com.haoxuer.b2bcloud.promote.data.dao.PromoteDao;
import com.haoxuer.b2bcloud.promote.data.entity.Promote;
import com.haoxuer.b2bcloud.promote.rest.conver.PromoteResponseConver;
import com.haoxuer.b2bcloud.promote.rest.conver.PromoteSimpleConver;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Component
public class PromoteResource implements PromoteApi {

    @Autowired
    private PromoteDao dataDao;

    @Override
    public PromoteResponse create(PromoteCreateRequest request) {
        PromoteResponse result = new PromoteResponse();

        Promote bean = new Promote();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new PromoteResponseConver().conver(bean);
        return result;
    }

    @Override
    public PromoteResponse update(PromoteUpdateRequest request) {
        PromoteResponse result = new PromoteResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Promote bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new PromoteResponseConver().conver(bean);
        return result;
    }

    private void handleData(PromoteCreateRequest request, Promote bean) {
        bean.setEnableState(request.getEnableState());
        bean.setNote(request.getNote());
        bean.setPlatformPromote(request.getPlatformPromote());
        bean.setMini(request.getMini());
        bean.setDiscountAmount(request.getDiscountAmount());
        bean.setPromoteScope(request.getPromoteScope());
        bean.setProductNum(request.getProductNum());
        bean.setOrderAmount(request.getOrderAmount());
        bean.setPromoteType(request.getPromoteType());
        bean.setConType(request.getConType());
        bean.setLogo(request.getLogo());
        bean.setName(request.getName());
        bean.setDiscountMode(request.getDiscountMode());
        bean.setStep(request.getStep());
    }

    @Override
    public PromoteResponse delete(PromoteViewRequest request) {
        PromoteResponse result = new PromoteResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(),request.getId());
        return result;
    }

    @Override
    public PromoteResponse view(PromoteViewRequest request) {
        PromoteResponse result=new PromoteResponse();
        Promote bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new PromoteResponseConver().conver(bean);
        return result;
    }
    @Override
    public PromoteList list(PromoteListRequest request) {
        PromoteList result = new PromoteList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.add(Filter.le("beginDate",new Date()));
        filters.add(Filter.ge("endDate",new Date()));
        filters.add(Filter.ge("scale",new BigDecimal(0.001)));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        List<Promote> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new PromoteSimpleConver());
        return result;
    }

    @Override
    public PromotePage search(PromoteSearchRequest request) {
        PromotePage result=new PromotePage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<Promote> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new PromoteSimpleConver());
        return result;
    }
}
