package com.haoxuer.b2bcloud.customer.rest.resource;

import com.haoxuer.b2bcloud.customer.api.apis.AddressApi;
import com.haoxuer.b2bcloud.customer.api.domain.page.AddressPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.AddressRequest;
import com.haoxuer.b2bcloud.customer.api.domain.response.AddressResponse;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerAddressDao;
import com.haoxuer.b2bcloud.customer.data.dao.ShopperDao;
import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerAddress;
import com.haoxuer.b2bcloud.customer.data.entity.Shopper;
import com.haoxuer.b2bcloud.customer.rest.conver.AddressConver;
import com.haoxuer.b2bcloud.customer.rest.conver.AddressResponseConver;
import com.haoxuer.b2bcloud.customer.rest.conver.AddressSimpleConver;
import com.haoxuer.b2bcloud.customer.rest.conver.CustomerAddressSimpleConver;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.bigworld.member.data.entity.TenantUser;
import com.haoxuer.bigworld.member.data.service.TenantTokenService;
import com.haoxuer.bigworld.member.rest.conver.PageableConver;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import com.haoxuer.discover.rest.base.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class AddressResource implements AddressApi {


    @Autowired
    CustomerAddressDao addressDao;

    @Autowired
    ShopperDao shopperDao;

    @Autowired
    private TenantTokenService tenantTokenService;

    @Override
    public AddressPage page(TenantPageRequest request) {
        AddressPage result = new AddressPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().add(Filter.eq("customer.id", tenantTokenService.user(request.getTenant(), request.getUserToken())));
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getOrders().add(Order.desc("updateDate"));
        Page<CustomerAddress> pagination = addressDao.page(pageable);
        ConverResourceUtils.converPage(result, pagination, new AddressSimpleConver());
        return result;
    }

    @Override
    public ResponseObject add(AddressRequest request) {
        ResponseObject result = new ResponseObject();
        Long uid = tenantTokenService.user(request.getTenant(), request.getUserToken());
        if (uid == null) {
            result.setCode(501);
            result.setMsg("无效token");
            return result;
        }
        CustomerAddress address = new AddressConver().conver(request);
        address.setTenant(Tenant.fromId(request.getTenant()));
        address.setCustomer(Customer.fromId(uid));

        addressDao.save(address);
        if (request.getDefaultState() == null) {
            request.setDefaultState(0);
        }
        if (request.getDefaultState() == 1) {
            Shopper shopper = shopperDao.findById(uid);
            if (shopper != null) {
                shopper.setAddressId(address.getId());
            }
        }
        return result;
    }

    @Override
    public ResponseObject delete(ViewRequest request) {
        ResponseObject result = new ResponseObject();
        Long uid = tenantTokenService.user(request.getTenant(), request.getUserToken());
        if (uid == null) {
            result.setCode(501);
            result.setMsg("无效token");
            return result;
        }
        CustomerAddress address = addressDao.one(Filter.eq("id", request.getId()), Filter.eq("customer.id", uid));
        if (address != null) {
            addressDao.deleteById(request.getId());
        }
        return result;
    }

    @Override
    public ResponseObject update(AddressRequest request) {
        ResponseObject result = new ResponseObject();
        Long uid = tenantTokenService.user(request.getTenant(), request.getUserToken());
        if (uid == null) {
            result.setCode(501);
            result.setMsg("无效token");
            return result;
        }
        if (request.getDefaultState() == null) {
            request.setDefaultState(0);
        }
        if (request.getId() == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        CustomerAddress address = addressDao.findById(request.getId());
        if (address == null) {
            result.setCode(503);
            result.setMsg("无效id");
            return result;
        }
        address.setAddress(request.getAddress());
        address.setName(request.getName());
        address.setNote(request.getNote());
        address.setCode(request.getCode());
        address.setLat(request.getLat());
        address.setLng(request.getLng());
        address.setPhone(request.getPhone());
        address.setTel(request.getTel());
        if (request.getDefaultState() == 1) {
            Shopper shopper = shopperDao.findById(uid);
            if (shopper != null) {
                shopper.setAddressId(address.getId());
                address.setUpdateDate(new Date());
            }
        }else{

        }
        return result;
    }

    @Override
    public ResponseObject updateSingle(AddressRequest request) {
        return null;
    }

    @Override
    public AddressResponse info(TenantRequest request) {

        AddressResponse result = new AddressResponse();
        Long uid = tenantTokenService.user(request.getTenant(), request.getUserToken());
        if (uid == null) {
            result.setCode(501);
            result.setMsg("无效token");
            return result;
        }
        CustomerAddress address = addressDao.one(
                Filter.eq("tenant.id", request.getTenant()),
                Filter.eq("customer.id", uid));
        if (address == null) {
            address = new CustomerAddress();
            address.setAddress("");
            address.setName("");
            address.setPhone("");
            address.setTenant(Tenant.fromId(request.getTenant()));
            address.setCustomer(Customer.fromId(uid));
            addressDao.save(address);
        }
        result = new AddressResponseConver().conver(address);

        return result;
    }
}
