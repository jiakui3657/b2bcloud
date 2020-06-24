package com.haoxuer.b2bcloud.customer.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerDao;
import com.haoxuer.b2bcloud.customer.data.entity.Customer;

/**
* Created by imake on 2020年01月13日13:03:05.
*/
@Repository

public class CustomerDaoImpl extends CriteriaDaoImpl<Customer, Long> implements CustomerDao {

	@Override
	public Customer findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Customer save(Customer bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Customer deleteById(Long id) {
		Customer entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Customer> getEntityClass() {
		return Customer.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}