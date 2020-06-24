package com.haoxuer.b2bcloud.customer.rest.conver;

import com.haoxuer.b2bcloud.customer.api.domain.simple.CustomerSimple;
import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.discover.data.rest.core.Conver;

public class CustomerSimpleConver implements Conver<CustomerSimple,Customer> {
    @Override
    public CustomerSimple conver(Customer source) {
        CustomerSimple result=new CustomerSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setPhone(source.getPhone());
        result.setShop(source.getShop());
        result.setLevel("一级");
        result.setNo(source.getNo());
        return result;
    }
}
