package com.haoxuer.b2bcloud.order.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.order.data.entity.OrderInvoice;

/**
* Created by imake on 2020年05月07日11:11:37.
*/
public interface OrderInvoiceDao extends BaseDao<OrderInvoice,Long>{

	 OrderInvoice findById(Long id);

	 OrderInvoice save(OrderInvoice bean);

	 OrderInvoice updateByUpdater(Updater<OrderInvoice> updater);

	 OrderInvoice deleteById(Long id);

	 OrderInvoice findById(Long tenant, Long id);

     OrderInvoice deleteById(Long tenant, Long id);
}