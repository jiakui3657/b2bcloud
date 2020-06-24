package com.haoxuer.b2bcloud.purchase.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.purchase.data.entity.Supplier;

/**
* Created by imake on 2020年05月12日19:55:07.
*/
public interface SupplierDao extends BaseDao<Supplier,Long>{

	 Supplier findById(Long id);

	 Supplier save(Supplier bean);

	 Supplier updateByUpdater(Updater<Supplier> updater);

	 Supplier deleteById(Long id);

	 Supplier findById(Long tenant, Long id);

     Supplier deleteById(Long tenant, Long id);
}