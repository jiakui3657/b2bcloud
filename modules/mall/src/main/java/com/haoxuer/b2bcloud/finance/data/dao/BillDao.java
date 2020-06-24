package com.haoxuer.b2bcloud.finance.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.finance.data.entity.Bill;

/**
* Created by imake on 2020年04月13日17:52:50.
*/
public interface BillDao extends BaseDao<Bill,Long>{

	 Bill findById(Long id);

	 Bill save(Bill bean);

	 Bill updateByUpdater(Updater<Bill> updater);

	 Bill deleteById(Long id);
}