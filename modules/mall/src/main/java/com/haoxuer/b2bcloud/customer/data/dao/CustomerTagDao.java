package com.haoxuer.b2bcloud.customer.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.customer.data.entity.CustomerTag;

/**
* Created by imake on 2020年05月09日15:47:39.
*/
public interface CustomerTagDao extends BaseDao<CustomerTag,Long>{

	 CustomerTag findById(Long id);

	 CustomerTag save(CustomerTag bean);

	 CustomerTag updateByUpdater(Updater<CustomerTag> updater);

	 CustomerTag deleteById(Long id);

	 CustomerTag findById(Long tenant, Long id);

     CustomerTag deleteById(Long tenant, Long id);
}