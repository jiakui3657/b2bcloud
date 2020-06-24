package com.haoxuer.b2bcloud.order.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.order.data.entity.OrderTally;

/**
* Created by imake on 2020年06月04日16:56:41.
*/
public interface OrderTallyDao extends BaseDao<OrderTally,Long>{

	 OrderTally findById(Long id);

	 OrderTally save(OrderTally bean);

	 OrderTally updateByUpdater(Updater<OrderTally> updater);

	 OrderTally deleteById(Long id);

	 OrderTally findById(Long tenant, Long id);

     OrderTally deleteById(Long tenant, Long id);
}