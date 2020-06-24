package com.haoxuer.b2bcloud.finance.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.finance.data.dao.BillDao;
import com.haoxuer.b2bcloud.finance.data.entity.Bill;

/**
* Created by imake on 2020年04月13日17:52:50.
*/
@Repository

public class BillDaoImpl extends CriteriaDaoImpl<Bill, Long> implements BillDao {

	@Override
	public Bill findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Bill save(Bill bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Bill deleteById(Long id) {
		Bill entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Bill> getEntityClass() {
		return Bill.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}