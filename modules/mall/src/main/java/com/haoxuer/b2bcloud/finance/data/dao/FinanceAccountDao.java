package com.haoxuer.b2bcloud.finance.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.finance.data.entity.FinanceAccount;

/**
* Created by imake on 2020年04月13日17:52:21.
*/
public interface FinanceAccountDao extends BaseDao<FinanceAccount,Long>{

	 FinanceAccount findById(Long id);

	 FinanceAccount save(FinanceAccount bean);

	 FinanceAccount updateByUpdater(Updater<FinanceAccount> updater);

	 FinanceAccount deleteById(Long id);
}