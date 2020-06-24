package com.haoxuer.b2bcloud.finance.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.finance.data.dao.FinanceStreamDao;
import com.haoxuer.b2bcloud.finance.data.entity.FinanceStream;

/**
* Created by imake on 2020年04月13日17:53:59.
*/
@Repository

public class FinanceStreamDaoImpl extends CriteriaDaoImpl<FinanceStream, Long> implements FinanceStreamDao {

	@Override
	public FinanceStream findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public FinanceStream save(FinanceStream bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public FinanceStream deleteById(Long id) {
		FinanceStream entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<FinanceStream> getEntityClass() {
		return FinanceStream.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}