package com.haoxuer.b2bcloud.finance.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.finance.data.entity.FinanceStream;

/**
* Created by imake on 2020年04月13日17:53:59.
*/
public interface FinanceStreamDao extends BaseDao<FinanceStream,Long>{

	 FinanceStream findById(Long id);

	 FinanceStream save(FinanceStream bean);

	 FinanceStream updateByUpdater(Updater<FinanceStream> updater);

	 FinanceStream deleteById(Long id);
}