package com.haoxuer.b2bcloud.customer.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.customer.data.entity.CustomerAddress;

/**
* Created by imake on 2020年03月30日15:51:03.
*/
public interface CustomerAddressDao extends BaseDao<CustomerAddress,Long>{

	 CustomerAddress findById(Long id);

	 CustomerAddress save(CustomerAddress bean);

	 CustomerAddress updateByUpdater(Updater<CustomerAddress> updater);

	 CustomerAddress deleteById(Long id);
}