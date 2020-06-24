package com.haoxuer.b2bcloud.order.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.order.data.entity.OrderExchange;

/**
* Created by imake on 2020年05月12日18:42:45.
*/
public interface OrderExchangeDao extends BaseDao<OrderExchange,Long>{

	 OrderExchange findById(Long id);

	 OrderExchange save(OrderExchange bean);

	 OrderExchange updateByUpdater(Updater<OrderExchange> updater);

	 OrderExchange deleteById(Long id);

	 OrderExchange findById(Long tenant, Long id);

     OrderExchange deleteById(Long tenant, Long id);
}