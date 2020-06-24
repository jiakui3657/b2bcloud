package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.response.AddressResponse;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerAddress;
import com.haoxuer.discover.data.rest.core.Conver;

public class AddressResponseConver implements Conver<AddressResponse, CustomerAddress> {
    @Override
    public AddressResponse conver(CustomerAddress source) {
        AddressResponse result = new AddressResponse();
        result.setId(source.getId());
        result.setAddress(source.getAddress());
        result.setName(source.getName());
        result.setNote(source.getNote());
        result.setLat(source.getLat());
        result.setLng(source.getLng());
        result.setPhone(source.getPhone());
        result.setTel(source.getTel());
        if (result.getName() == null) {
            result.setName("");
        }
        if (result.getPhone() == null) {
            result.setPhone("");
        }
        if (result.getAddress() == null) {
            result.setAddress("");
        }
        return result;
    }
}
