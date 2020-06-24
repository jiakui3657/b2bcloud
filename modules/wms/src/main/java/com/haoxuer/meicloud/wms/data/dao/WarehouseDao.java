package com.haoxuer.meicloud.wms.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.meicloud.wms.data.entity.Warehouse;

/**
* Created by imake on 2019年11月20日17:50:41.
*/
public interface WarehouseDao extends BaseDao<Warehouse,Long>{

	 Warehouse findById(Long id);

	 Warehouse save(Warehouse bean);

	 Warehouse updateByUpdater(Updater<Warehouse> updater);

	 Warehouse deleteById(Long id);
}