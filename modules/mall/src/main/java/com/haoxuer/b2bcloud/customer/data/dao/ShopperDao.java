package com.haoxuer.b2bcloud.customer.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.customer.data.entity.Shopper;

/**
* Created by imake on 2020年03月30日16:06:23.
*/
public interface ShopperDao extends BaseDao<Shopper,Long>{

	 Shopper findById(Long id);

	 Shopper save(Shopper bean);

	 Shopper updateByUpdater(Updater<Shopper> updater);

	 Shopper deleteById(Long id);
}