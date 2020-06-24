package com.haoxuer.b2bcloud.customer.rest.resource;

import com.haoxuer.b2bcloud.customer.api.apis.CustomerApi;
import com.haoxuer.b2bcloud.customer.api.domain.list.CustomerList;
import com.haoxuer.b2bcloud.customer.api.domain.page.CustomerPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerResponse;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerDao;
import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.b2bcloud.customer.rest.conver.CustomerResponseConver;
import com.haoxuer.b2bcloud.customer.rest.conver.CustomerSimpleConver;
import com.haoxuer.bigworld.company.data.entity.Employee;
import com.haoxuer.bigworld.member.data.dao.TenantUserDao;
import com.haoxuer.bigworld.member.data.enums.BindType;
import com.haoxuer.bigworld.member.data.request.UserRegisterRequest;
import com.haoxuer.bigworld.member.data.response.UserBasicResponse;
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
import java.util.List;

@Transactional
@Component
public class CustomerResource implements CustomerApi {

    @Autowired
    private CustomerDao dataDao;

    @Autowired
    private TenantUserDao userDao;

    @Override
    public CustomerResponse create(CustomerCreateRequest request) {
        CustomerResponse result = new CustomerResponse();
        if (StringUtil.isEmpty(request.getNo())) {
            result.setCode(501);
            result.setMsg("账号不能为空");
            return result;
        }
        if (StringUtil.isEmpty(request.getPassword())) {
            result.setCode(502);
            result.setMsg("密码不能为空");
            return result;
        }
        UserRegisterRequest beanTemp = new UserRegisterRequest();
        beanTemp.setBindType(BindType.account);
        beanTemp.setUsername(request.getNo());
        beanTemp.setPassword(request.getPassword());
        beanTemp.setTenant(request.getTenant());
        UserBasicResponse back = userDao.register(beanTemp);
        if (back.getCode()!=0){
            result.setCode(back.getCode());
            result.setMsg(back.getMsg());
            return result;
        }
        Customer bean =dataDao.findById(back.getId());
        if (bean==null){
            result.setCode(505);
            result.setMsg("系统错误");
            return result;
        }
        bean.setName(request.getName());
        bean.setPhone(request.getPhone());
        bean.setShop(request.getShop());
        bean.setAvatar(request.getAvatar());
        bean.setDataType(2000);
        result = new CustomerResponseConver().conver(bean);
        return result;
    }

    @Override
    public CustomerResponse update(CustomerUpdateRequest request) {
        CustomerResponse result = new CustomerResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Customer org = dataDao.findById(request.getId());
        if (org == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        if (StringUtil.isNotEmpty(request.getName())) {
            org.setName(request.getName().trim());
        }
        result = new CustomerResponseConver().conver(org);
        return result;
    }

    @Override
    public CustomerResponse delete(CustomerDeleteRequest request) {
        CustomerResponse result = new CustomerResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public CustomerList list(CustomerListRequest request) {
        CustomerList result = new CustomerList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<Customer> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new CustomerSimpleConver());
        return result;
    }

    @Override
    public CustomerPage search(CustomerSearchRequest request) {
        CustomerPage result=new CustomerPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getFilters().add(Filter.eq("dataType", 2000));
        Page<Customer> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new CustomerSimpleConver());
        return result;
    }
}
