package com.haoxuer.meicloud.wms.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.meicloud.wms.data.entity.Good;

/**
* Created by imake on 2019年11月20日12:11:02.
*/
public interface GoodDao extends BaseDao<Good,Long>{

	 Good findById(Long id);

	 Good save(Good bean);

	 Good updateByUpdater(Updater<Good> updater);

	 Good deleteById(Long id);
}