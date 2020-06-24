package com.haoxuer.b2bcloud.mall.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.mall.data.entity.GoodsSkuSpu;

/**
* Created by imake on 2020年01月17日14:09:33.
*/
public interface GoodsSkuSpuDao extends BaseDao<GoodsSkuSpu,Long>{

	 GoodsSkuSpu findById(Long id);

	 GoodsSkuSpu save(GoodsSkuSpu bean);

	 GoodsSkuSpu updateByUpdater(Updater<GoodsSkuSpu> updater);

	 GoodsSkuSpu deleteById(Long id);
}