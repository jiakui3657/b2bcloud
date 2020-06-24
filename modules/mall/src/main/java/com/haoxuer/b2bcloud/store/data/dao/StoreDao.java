package com.haoxuer.b2bcloud.store.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.store.data.entity.Store;

/**
* Created by imake on 2020年05月02日15:43:56.
*/
public interface StoreDao extends BaseDao<Store,Long>{

	 Store findById(Long id);

	 Store save(Store bean);

	 Store updateByUpdater(Updater<Store> updater);

	 Store deleteById(Long id);

	 Store findById(Long tenant, Long id);

     Store deleteById(Long tenant, Long id);
}