package com.haoxuer.b2bcloud.mall.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.mall.data.entity.SpuName;

/**
* Created by imake on 2019年12月31日15:41:42.
*/
public interface SpuNameDao extends BaseDao<SpuName,Long>{

	 SpuName findById(Long id);

	 SpuName save(SpuName bean);

	 SpuName updateByUpdater(Updater<SpuName> updater);

	 SpuName deleteById(Long id);
}