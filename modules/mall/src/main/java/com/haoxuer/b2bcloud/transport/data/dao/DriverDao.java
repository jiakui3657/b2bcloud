package com.haoxuer.b2bcloud.transport.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.transport.data.entity.Driver;

/**
* Created by imake on 2020年03月21日16:54:58.
*/
public interface DriverDao extends BaseDao<Driver,Long>{

	 Driver findById(Long id);

	 Driver save(Driver bean);

	 Driver updateByUpdater(Updater<Driver> updater);

	 Driver deleteById(Long id);
}