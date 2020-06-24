package com.haoxuer.meicloud.wms.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.meicloud.wms.data.entity.WarehouseCatalog;

/**
* Created by imake on 2019年11月20日17:46:43.
*/
public interface WarehouseCatalogDao extends BaseDao<WarehouseCatalog,Integer>{

	 WarehouseCatalog findById(Integer id);

	 WarehouseCatalog save(WarehouseCatalog bean);

	 WarehouseCatalog updateByUpdater(Updater<WarehouseCatalog> updater);

	 WarehouseCatalog deleteById(Integer id);
}