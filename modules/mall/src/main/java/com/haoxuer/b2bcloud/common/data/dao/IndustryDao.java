package com.haoxuer.b2bcloud.common.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.common.data.entity.Industry;

/**
* Created by imake on 2020年05月07日14:03:56.
*/
public interface IndustryDao extends BaseDao<Industry,Integer>{

	 Industry findById(Integer id);

	 Industry save(Industry bean);

	 Industry updateByUpdater(Updater<Industry> updater);

	 Industry deleteById(Integer id);

	 Industry findById(Long tenant, Integer id);

     Industry deleteById(Long tenant, Integer id);
}