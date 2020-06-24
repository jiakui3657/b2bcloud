package com.haoxuer.b2bcloud.finance.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.finance.data.entity.Invoice;

/**
* Created by imake on 2020年05月15日17:23:36.
*/
public interface InvoiceDao extends BaseDao<Invoice,Long>{

	 Invoice findById(Long id);

	 Invoice save(Invoice bean);

	 Invoice updateByUpdater(Updater<Invoice> updater);

	 Invoice deleteById(Long id);

	 Invoice findById(Long tenant, Long id);

     Invoice deleteById(Long tenant, Long id);
}