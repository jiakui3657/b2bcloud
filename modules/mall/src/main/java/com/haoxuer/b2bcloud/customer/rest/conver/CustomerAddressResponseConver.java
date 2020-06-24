package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerAddressResponse;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerAddress;
import com.haoxuer.discover.data.rest.core.Conver;

public class CustomerAddressResponseConver implements Conver<CustomerAddressResponse, CustomerAddress> {
    @Override
    public CustomerAddressResponse conver(CustomerAddress source) {
        CustomerAddressResponse result = new CustomerAddressResponse();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
