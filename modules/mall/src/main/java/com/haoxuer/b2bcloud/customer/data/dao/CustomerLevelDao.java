package com.haoxuer.b2bcloud.customer.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.customer.data.entity.CustomerLevel;

/**
* Created by imake on 2020年05月07日11:15:21.
*/
public interface CustomerLevelDao extends BaseDao<CustomerLevel,Long>{

	 CustomerLevel findById(Long id);

	 CustomerLevel save(CustomerLevel bean);

	 CustomerLevel updateByUpdater(Updater<CustomerLevel> updater);

	 CustomerLevel deleteById(Long id);

	 CustomerLevel findById(Long tenant, Long id);

     CustomerLevel deleteById(Long tenant, Long id);
}