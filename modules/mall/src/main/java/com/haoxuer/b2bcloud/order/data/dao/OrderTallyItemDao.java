package com.haoxuer.b2bcloud.order.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.order.data.entity.OrderTallyItem;

/**
* Created by imake on 2020年06月04日16:13:57.
*/
public interface OrderTallyItemDao extends BaseDao<OrderTallyItem,Long>{

	 OrderTallyItem findById(Long id);

	 OrderTallyItem save(OrderTallyItem bean);

	 OrderTallyItem updateByUpdater(Updater<OrderTallyItem> updater);

	 OrderTallyItem deleteById(Long id);

	 OrderTallyItem findById(Long tenant, Long id);

     OrderTallyItem deleteById(Long tenant, Long id);
}