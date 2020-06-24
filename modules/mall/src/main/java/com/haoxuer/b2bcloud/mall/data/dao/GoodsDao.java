package com.haoxuer.b2bcloud.mall.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.mall.data.entity.Goods;

/**
* Created by imake on 2019年12月29日13:46:48.
*/
public interface GoodsDao extends BaseDao<Goods,Long>{

	 Goods findById(Long id);

	 Goods save(Goods bean);

	 Goods updateByUpdater(Updater<Goods> updater);

	 Goods deleteById(Long id);
}