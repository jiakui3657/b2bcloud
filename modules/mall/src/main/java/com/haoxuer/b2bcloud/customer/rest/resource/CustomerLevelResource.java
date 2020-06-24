package com.haoxuer.b2bcloud.customer.rest.resource;

import com.haoxuer.b2bcloud.customer.api.apis.CustomerLevelApi;
import com.haoxuer.b2bcloud.customer.api.domain.list.CustomerLevelList;
import com.haoxuer.b2bcloud.customer.api.domain.page.CustomerLevelPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerLevelResponse;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerLevelDao;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerLevel;
import com.haoxuer.b2bcloud.customer.rest.conver.CustomerLevelResponseConver;
import com.haoxuer.b2bcloud.customer.rest.conver.CustomerLevelSimpleConver;
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
public class CustomerLevelResource implements CustomerLevelApi {

    @Autowired
    private CustomerLevelDao dataDao;

    @Override
    public CustomerLevelResponse create(CustomerLevelCreateRequest request) {
        CustomerLevelResponse result = new CustomerLevelResponse();

        CustomerLevel bean = new CustomerLevel();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new CustomerLevelResponseConver().conver(bean);
        return result;
    }

    @Override
    public CustomerLevelResponse update(CustomerLevelUpdateRequest request) {
        CustomerLevelResponse result = new CustomerLevelResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        CustomerLevel bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new CustomerLevelResponseConver().conver(bean);
        return result;
    }

    private void handleData(CustomerLevelCreateRequest request, CustomerLevel bean) {
        if (StringUtil.isNotEmpty(request.getName())) {
            bean.setName(request.getName().trim());
        }
        bean.setMoney(request.getMoney());
        bean.setRebate(request.getRebate());
    }

    @Override
    public CustomerLevelResponse delete(CustomerLevelDeleteRequest request) {
        CustomerLevelResponse result = new CustomerLevelResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(), request.getId());
        return result;
    }

    @Override
    public CustomerLevelResponse view(ViewRequest request) {
        CustomerLevelResponse result = new CustomerLevelResponse();
        CustomerLevel bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean == null) {
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result = new CustomerLevelResponseConver().conver(bean);
        return result;
    }

    @Override
    public CustomerLevelList list(CustomerLevelListRequest request) {
        CustomerLevelList result = new CustomerLevelList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<CustomerLevel> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new CustomerLevelSimpleConver());
        return result;
    }

    @Override
    public CustomerLevelPage search(CustomerLevelSearchRequest request) {
        CustomerLevelPage result = new CustomerLevelPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<CustomerLevel> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new CustomerLevelSimpleConver());
        return result;
    }
}
