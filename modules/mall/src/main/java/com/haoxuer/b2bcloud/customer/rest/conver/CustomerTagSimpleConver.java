package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.simple.CustomerTagSimple;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerTag;
import com.haoxuer.discover.data.rest.core.Conver;

public class CustomerTagSimpleConver implements Conver<CustomerTagSimple, CustomerTag> {
    @Override
    public CustomerTagSimple conver(CustomerTag source) {
        CustomerTagSimple result = new CustomerTagSimple();
        result.setId(source.getId());
        result.setNum(source.getNum());
        result.setName(source.getName());

        return result;
    }
}
