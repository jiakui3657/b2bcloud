package com.haoxuer.b2bcloud.customer.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.customer.data.entity.Customer;

/**
* Created by imake on 2020年01月13日13:03:05.
*/
public interface CustomerDao extends BaseDao<Customer,Long>{

	 Customer findById(Long id);

	 Customer save(Customer bean);

	 Customer updateByUpdater(Updater<Customer> updater);

	 Customer deleteById(Long id);
}