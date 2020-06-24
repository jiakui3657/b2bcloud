package com.haoxuer.b2bcloud.mall.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.mall.data.entity.GoodsSpu;

/**
* Created by imake on 2019年12月29日13:42:02.
*/
public interface GoodsSpuDao extends BaseDao<GoodsSpu,Long>{

	 GoodsSpu findById(Long id);

	 GoodsSpu save(GoodsSpu bean);

	 GoodsSpu updateByUpdater(Updater<GoodsSpu> updater);

	 GoodsSpu deleteById(Long id);
}