package com.haoxuer.b2bcloud.customer.rest.resource;

import com.haoxuer.b2bcloud.customer.api.apis.CustomerAddressApi;
import com.haoxuer.b2bcloud.customer.api.domain.list.CustomerAddressList;
import com.haoxuer.b2bcloud.customer.api.domain.page.CustomerAddressPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.AddressResponse;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerAddressResponse;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerAddressDao;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerDao;
import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerAddress;
import com.haoxuer.b2bcloud.customer.rest.conver.AddressResponseConver;
import com.haoxuer.b2bcloud.customer.rest.conver.CustomerAddressResponseConver;
import com.haoxuer.b2bcloud.customer.rest.conver.CustomerAddressSimpleConver;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.member.data.dao.TenantUserDao;
import com.haoxuer.bigworld.member.data.entity.TenantUser;
import com.haoxuer.bigworld.member.rest.conver.PageableConver;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Component
public class CustomerAddressResource implements CustomerAddressApi {

    @Autowired
    private CustomerAddressDao dataDao;

    @Autowired
    private CustomerDao userDao;

    @Override
    public CustomerAddressResponse create(CustomerAddressCreateRequest request) {
        CustomerAddressResponse result = new CustomerAddressResponse();
        Customer user = userDao.findById(request.getUser());
        if (user == null) {
            result.setCode(1001);
            result.setMsg("用户id不能为空");
            return result;
        }


        CustomerAddress bean = new CustomerAddress();
        bean.setAddress(request.getAddress());
        bean.setNote(request.getNote());
        bean.setCode(request.getCode());
        bean.setLat(request.getLat());
        bean.setLng(request.getLng());
        bean.setPhone(request.getPhone());
        bean.setTel(request.getTel());
        bean.setName(request.getName());
        bean.setTenant(Tenant.fromId(request.getTenant()));
        bean.setCustomer(user);
        dataDao.save(bean);
        if (request.getDefaultState() != null && request.getDefaultState() == 1) {
            user.setAddressId(bean.getId());
        }

        result = new CustomerAddressResponseConver().conver(bean);
        return result;
    }

    @Override
    public CustomerAddressResponse update(CustomerAddressUpdateRequest request) {
        CustomerAddressResponse result = new CustomerAddressResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Customer user = userDao.findById(request.getUser());
        if (user == null) {
            result.setCode(1001);
            result.setMsg("用户id不能为空");
            return result;
        }
        CustomerAddress bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(1002);
            result.setMsg("无效id");
            return result;
        }

        bean.setAddress(request.getAddress());
        bean.setNote(request.getNote());
        bean.setCode(request.getCode());
        bean.setLat(request.getLat());
        bean.setLng(request.getLng());
        bean.setPhone(request.getPhone());
        bean.setTel(request.getTel());
        bean.setName(request.getName());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        if (StringUtil.isNotEmpty(request.getName())) {
            bean.setName(request.getName().trim());
        }
        if (request.getDefaultState() != null && request.getDefaultState() == 1) {
            user.setAddressId(bean.getId());
            user.setLastDate(new Date());
        }
        result = new CustomerAddressResponseConver().conver(bean);
        return result;
    }

    @Override
    public CustomerAddressResponse delete(CustomerAddressDeleteRequest request) {
        CustomerAddressResponse result = new CustomerAddressResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public CustomerAddressList list(CustomerAddressListRequest request) {
        CustomerAddressList result = new CustomerAddressList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.desc("lastDate"));
        List<CustomerAddress> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new CustomerAddressSimpleConver());
        return result;
    }

    @Override
    public CustomerAddressPage search(CustomerAddressSearchRequest request) {
        CustomerAddressPage result = new CustomerAddressPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("updateDate"));
        Page<CustomerAddress> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new CustomerAddressSimpleConver());
        return result;
    }

}
