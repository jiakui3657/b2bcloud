package com.haoxuer.b2bcloud.customer.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.customer.data.entity.CustomerAccount;

/**
* Created by imake on 2020年03月27日21:05:33.
*/
public interface CustomerAccountDao extends BaseDao<CustomerAccount,Long>{

	 CustomerAccount findById(Long id);

	 CustomerAccount save(CustomerAccount bean);

	 CustomerAccount updateByUpdater(Updater<CustomerAccount> updater);

	 CustomerAccount deleteById(Long id);
}