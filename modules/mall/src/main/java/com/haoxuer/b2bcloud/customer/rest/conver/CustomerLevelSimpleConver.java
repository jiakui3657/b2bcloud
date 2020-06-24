package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.simple.CustomerLevelSimple;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerLevel;
import com.haoxuer.discover.data.rest.core.Conver;

public class CustomerLevelSimpleConver implements Conver<CustomerLevelSimple, CustomerLevel> {
    @Override
    public CustomerLevelSimple conver(CustomerLevel source) {
        CustomerLevelSimple result = new CustomerLevelSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setMoney(source.getMoney());
        result.setRebate(source.getRebate());
        return result;
    }
}
