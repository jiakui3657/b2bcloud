package com.haoxuer.b2bcloud.order.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.order.data.entity.OrderTradeItem;

/**
* Created by imake on 2020年05月19日18:20:02.
*/
public interface OrderTradeItemDao extends BaseDao<OrderTradeItem,Long>{

	 OrderTradeItem findById(Long id);

	 OrderTradeItem save(OrderTradeItem bean);

	 OrderTradeItem updateByUpdater(Updater<OrderTradeItem> updater);

	 OrderTradeItem deleteById(Long id);

	 OrderTradeItem findById(Long tenant, Long id);

     OrderTradeItem deleteById(Long tenant, Long id);
}