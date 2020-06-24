package com.haoxuer.b2bcloud.transport.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.transport.data.entity.VehicleType;

/**
* Created by imake on 2020年03月21日16:54:10.
*/
public interface VehicleTypeDao extends BaseDao<VehicleType,Long>{

	 VehicleType findById(Long id);

	 VehicleType save(VehicleType bean);

	 VehicleType updateByUpdater(Updater<VehicleType> updater);

	 VehicleType deleteById(Long id);
}