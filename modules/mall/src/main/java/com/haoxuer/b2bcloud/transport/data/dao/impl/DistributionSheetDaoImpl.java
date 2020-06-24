package com.haoxuer.b2bcloud.transport.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.transport.data.dao.DistributionSheetDao;
import com.haoxuer.b2bcloud.transport.data.entity.DistributionSheet;

/**
* Created by imake on 2020年03月21日16:55:54.
*/
@Repository

public class DistributionSheetDaoImpl extends CriteriaDaoImpl<DistributionSheet, Long> implements DistributionSheetDao {

	@Override
	public DistributionSheet findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public DistributionSheet save(DistributionSheet bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public DistributionSheet deleteById(Long id) {
		DistributionSheet entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<DistributionSheet> getEntityClass() {
		return DistributionSheet.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}