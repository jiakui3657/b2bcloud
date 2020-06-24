package com.haoxuer.b2bcloud.order.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.order.data.entity.OrderRefund;

/**
* Created by imake on 2020年05月09日23:00:47.
*/
public interface OrderRefundDao extends BaseDao<OrderRefund,Long>{

	 OrderRefund findById(Long id);

	 OrderRefund save(OrderRefund bean);

	 OrderRefund updateByUpdater(Updater<OrderRefund> updater);

	 OrderRefund deleteById(Long id);

	 OrderRefund findById(Long tenant, Long id);

     OrderRefund deleteById(Long tenant, Long id);
}