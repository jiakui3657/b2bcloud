package com.haoxuer.b2bcloud.order.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.order.data.entity.OrderRefundItem;

/**
* Created by imake on 2020年06月18日10:29:26.
*/
public interface OrderRefundItemDao extends BaseDao<OrderRefundItem,Long>{

	 OrderRefundItem findById(Long id);

	 OrderRefundItem save(OrderRefundItem bean);

	 OrderRefundItem updateByUpdater(Updater<OrderRefundItem> updater);

	 OrderRefundItem deleteById(Long id);

	 OrderRefundItem findById(Long tenant, Long id);

     OrderRefundItem deleteById(Long tenant, Long id);
}