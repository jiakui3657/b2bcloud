package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.request.AddressRequest;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerAddress;
import com.haoxuer.discover.data.rest.core.Conver;

import java.util.Date;

public class AddressConver implements Conver<CustomerAddress, AddressRequest> {
    @Override
    public CustomerAddress conver(AddressRequest source) {
        CustomerAddress result=new CustomerAddress();
        result.setAddress(source.getAddress());
        result.setName(source.getName());
        result.setNote(source.getNote());
        result.setCode(source.getCode());
        result.setLat(source.getLat());
        result.setLng(source.getLng());
        result.setPhone(source.getPhone());
        result.setTel(source.getTel());
        result.setUpdateDate(new Date());
        return result;
    }
}
