package com.haoxuer.b2bcloud.customer.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerAddressDao;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerAddress;

/**
* Created by imake on 2020年03月30日15:51:03.
*/
@Repository

public class CustomerAddressDaoImpl extends CriteriaDaoImpl<CustomerAddress, Long> implements CustomerAddressDao {

	@Override
	public CustomerAddress findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public CustomerAddress save(CustomerAddress bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public CustomerAddress deleteById(Long id) {
		CustomerAddress entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<CustomerAddress> getEntityClass() {
		return CustomerAddress.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}