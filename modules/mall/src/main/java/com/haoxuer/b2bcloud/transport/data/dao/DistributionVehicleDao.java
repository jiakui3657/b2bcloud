package com.haoxuer.b2bcloud.transport.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.transport.data.entity.DistributionVehicle;

/**
* Created by imake on 2020年03月21日16:54:32.
*/
public interface DistributionVehicleDao extends BaseDao<DistributionVehicle,Long>{

	 DistributionVehicle findById(Long id);

	 DistributionVehicle save(DistributionVehicle bean);

	 DistributionVehicle updateByUpdater(Updater<DistributionVehicle> updater);

	 DistributionVehicle deleteById(Long id);
}