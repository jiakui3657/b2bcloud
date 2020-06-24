package com.haoxuer.b2bcloud.mall.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.mall.data.entity.GoodsBrand;

/**
* Created by imake on 2019年12月29日14:17:43.
*/
public interface GoodsBrandDao extends BaseDao<GoodsBrand,Long>{

	 GoodsBrand findById(Long id);

	 GoodsBrand save(GoodsBrand bean);

	 GoodsBrand updateByUpdater(Updater<GoodsBrand> updater);

	 GoodsBrand deleteById(Long id);
}