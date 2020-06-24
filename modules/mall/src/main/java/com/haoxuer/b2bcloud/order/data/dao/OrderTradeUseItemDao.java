package com.haoxuer.b2bcloud.order.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.order.data.entity.OrderTradeUseItem;

/**
* Created by imake on 2020年05月19日18:20:02.
*/
public interface OrderTradeUseItemDao extends BaseDao<OrderTradeUseItem,Long>{

	 OrderTradeUseItem findById(Long id);

	 OrderTradeUseItem save(OrderTradeUseItem bean);

	 OrderTradeUseItem updateByUpdater(Updater<OrderTradeUseItem> updater);

	 OrderTradeUseItem deleteById(Long id);

	 OrderTradeUseItem findById(Long tenant, Long id);

     OrderTradeUseItem deleteById(Long tenant, Long id);
}