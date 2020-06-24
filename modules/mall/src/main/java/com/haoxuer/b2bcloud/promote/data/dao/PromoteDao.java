package com.haoxuer.b2bcloud.promote.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.promote.data.entity.Promote;

/**
* Created by imake on 2020年05月11日14:18:16.
*/
public interface PromoteDao extends BaseDao<Promote,Long>{

	 Promote findById(Long id);

	 Promote save(Promote bean);

	 Promote updateByUpdater(Updater<Promote> updater);

	 Promote deleteById(Long id);

	 Promote findById(Long tenant, Long id);

     Promote deleteById(Long tenant, Long id);
}