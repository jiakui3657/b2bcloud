package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerTagResponse;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerTag;
import com.haoxuer.discover.data.rest.core.Conver;

public class CustomerTagResponseConver implements Conver<CustomerTagResponse, CustomerTag> {
    @Override
    public CustomerTagResponse conver(CustomerTag source) {
        CustomerTagResponse result = new CustomerTagResponse();
        result.setId(source.getId());
        result.setNum(source.getNum());
        result.setName(source.getName());
        return result;
    }
}
