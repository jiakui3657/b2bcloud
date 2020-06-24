package com.haoxuer.b2bcloud.mall.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.mall.data.entity.GoodsSku;

/**
* Created by imake on 2020年01月17日14:08:58.
*/
public interface GoodsSkuDao extends BaseDao<GoodsSku,Long>{

	 GoodsSku findById(Long id);

	 GoodsSku save(GoodsSku bean);

	 GoodsSku updateByUpdater(Updater<GoodsSku> updater);

	 GoodsSku deleteById(Long id);
}