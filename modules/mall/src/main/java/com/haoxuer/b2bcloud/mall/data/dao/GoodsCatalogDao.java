package com.haoxuer.b2bcloud.mall.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.mall.data.entity.GoodsCatalog;

/**
* Created by imake on 2019年12月29日13:42:18.
*/
public interface GoodsCatalogDao extends BaseDao<GoodsCatalog,Integer>{

	 GoodsCatalog findById(Integer id);

	 GoodsCatalog save(GoodsCatalog bean);

	 GoodsCatalog updateByUpdater(Updater<GoodsCatalog> updater);

	 GoodsCatalog deleteById(Integer id);
}