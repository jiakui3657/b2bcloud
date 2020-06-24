package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerLevelResponse;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerLevel;
import com.haoxuer.discover.data.rest.core.Conver;

public class CustomerLevelResponseConver implements Conver<CustomerLevelResponse, CustomerLevel> {
    @Override
    public CustomerLevelResponse conver(CustomerLevel source) {
        CustomerLevelResponse result = new CustomerLevelResponse();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setMoney(source.getMoney());
        result.setRebate(source.getRebate());
        return result;
    }
}
