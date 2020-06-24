package com.haoxuer.b2bcloud.common.rest.resource;

import com.haoxuer.b2bcloud.common.api.apis.IndustryApi;
import com.haoxuer.b2bcloud.common.api.domain.list.IndustryList;
import com.haoxuer.b2bcloud.common.api.domain.page.IndustryPage;
import com.haoxuer.b2bcloud.common.api.domain.request.*;
import com.haoxuer.b2bcloud.common.api.domain.response.IndustryResponse;
import com.haoxuer.b2bcloud.common.data.dao.IndustryDao;
import com.haoxuer.b2bcloud.common.data.entity.Industry;
import com.haoxuer.b2bcloud.common.rest.conver.IndustryResponseConver;
import com.haoxuer.b2bcloud.common.rest.conver.IndustrySimpleConver;
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
public class IndustryResource implements IndustryApi {

    @Autowired
    private IndustryDao dataDao;

    @Override
    public IndustryResponse create(IndustryCreateRequest request) {
        IndustryResponse result = new IndustryResponse();

        Industry bean = new Industry();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new IndustryResponseConver().conver(bean);
        return result;
    }

    @Override
    public IndustryResponse update(IndustryUpdateRequest request) {
        IndustryResponse result = new IndustryResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Industry bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new IndustryResponseConver().conver(bean);
        return result;
    }

    private void handleData(IndustryCreateRequest request, Industry bean) {
        if (StringUtil.isNotEmpty(request.getName())) {
            bean.setName(request.getName().trim());
        }
    }

    @Override
    public IndustryResponse delete(IndustryDeleteRequest request) {
        IndustryResponse result = new IndustryResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(),request.getId());
        return result;
    }

    @Override
    public IndustryResponse view(ViewRequest request) {
        IndustryResponse result=new IndustryResponse();
        Industry bean = dataDao.findById(request.getTenant(),Integer.valueOf(""+request.getId()) );
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new IndustryResponseConver().conver(bean);
        return result;
    }
    @Override
    public IndustryList list(IndustryListRequest request) {
        IndustryList result = new IndustryList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<Industry> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new IndustrySimpleConver());
        return result;
    }

    @Override
    public IndustryPage search(IndustrySearchRequest request) {
        IndustryPage result=new IndustryPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<Industry> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new IndustrySimpleConver());
        return result;
    }
}
