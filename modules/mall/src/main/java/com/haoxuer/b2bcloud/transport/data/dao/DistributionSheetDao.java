package com.haoxuer.b2bcloud.transport.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.transport.data.entity.DistributionSheet;

/**
* Created by imake on 2020年03月21日16:55:54.
*/
public interface DistributionSheetDao extends BaseDao<DistributionSheet,Long>{

	 DistributionSheet findById(Long id);

	 DistributionSheet save(DistributionSheet bean);

	 DistributionSheet updateByUpdater(Updater<DistributionSheet> updater);

	 DistributionSheet deleteById(Long id);
}