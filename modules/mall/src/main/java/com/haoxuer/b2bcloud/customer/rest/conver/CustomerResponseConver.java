package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerResponse;
import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.discover.data.rest.core.Conver;

public class CustomerResponseConver implements Conver<CustomerResponse, Customer> {
    @Override
    public CustomerResponse conver(Customer source) {
        CustomerResponse result = new CustomerResponse();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
