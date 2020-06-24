package com.haoxuer.b2bcloud.transport.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.transport.data.dao.DistributionVehicleDao;
import com.haoxuer.b2bcloud.transport.data.entity.DistributionVehicle;

/**
* Created by imake on 2020年03月21日16:54:32.
*/
@Repository

public class DistributionVehicleDaoImpl extends CriteriaDaoImpl<DistributionVehicle, Long> implements DistributionVehicleDao {

	@Override
	public DistributionVehicle findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public DistributionVehicle save(DistributionVehicle bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public DistributionVehicle deleteById(Long id) {
		DistributionVehicle entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<DistributionVehicle> getEntityClass() {
		return DistributionVehicle.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}