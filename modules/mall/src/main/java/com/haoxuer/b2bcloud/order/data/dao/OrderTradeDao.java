package com.haoxuer.b2bcloud.order.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.order.data.entity.OrderTrade;

/**
* Created by imake on 2020年05月18日19:57:06.
*/
public interface OrderTradeDao extends BaseDao<OrderTrade,Long>{

	 OrderTrade findById(Long id);

	 OrderTrade save(OrderTrade bean);

	 OrderTrade updateByUpdater(Updater<OrderTrade> updater);

	 OrderTrade deleteById(Long id);

	 OrderTrade findById(Long tenant, Long id);

     OrderTrade deleteById(Long tenant, Long id);
}