package com.haoxuer.b2bcloud.customer.rest.resource;

import com.haoxuer.b2bcloud.customer.api.apis.CustomerTagApi;
import com.haoxuer.b2bcloud.customer.api.domain.list.CustomerTagList;
import com.haoxuer.b2bcloud.customer.api.domain.page.CustomerTagPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerTagResponse;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerTagDao;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerTag;
import com.haoxuer.b2bcloud.customer.rest.conver.CustomerTagResponseConver;
import com.haoxuer.b2bcloud.customer.rest.conver.CustomerTagSimpleConver;
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
public class CustomerTagResource implements CustomerTagApi {

    @Autowired
    private CustomerTagDao dataDao;

    @Override
    public CustomerTagResponse create(CustomerTagCreateRequest request) {
        CustomerTagResponse result = new CustomerTagResponse();

        CustomerTag bean = new CustomerTag();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new CustomerTagResponseConver().conver(bean);
        return result;
    }

    @Override
    public CustomerTagResponse update(CustomerTagUpdateRequest request) {
        CustomerTagResponse result = new CustomerTagResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        CustomerTag bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new CustomerTagResponseConver().conver(bean);
        return result;
    }

    private void handleData(CustomerTagCreateRequest request, CustomerTag bean) {
        bean.setNum(request.getNum());
        bean.setName(request.getName());
    }

    @Override
    public CustomerTagResponse delete(CustomerTagViewRequest request) {
        CustomerTagResponse result = new CustomerTagResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(),request.getId());
        return result;
    }

    @Override
    public CustomerTagResponse view(CustomerTagViewRequest request) {
        CustomerTagResponse result=new CustomerTagResponse();
        CustomerTag bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new CustomerTagResponseConver().conver(bean);
        return result;
    }
    @Override
    public CustomerTagList list(CustomerTagListRequest request) {
        CustomerTagList result = new CustomerTagList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<CustomerTag> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new CustomerTagSimpleConver());
        return result;
    }

    @Override
    public CustomerTagPage search(CustomerTagSearchRequest request) {
        CustomerTagPage result=new CustomerTagPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<CustomerTag> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new CustomerTagSimpleConver());
        return result;
    }
}
