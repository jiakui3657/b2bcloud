package com.haoxuer.b2bcloud.customer.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerAccountDao;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerAccount;

/**
* Created by imake on 2020年03月27日21:05:33.
*/
@Repository

public class CustomerAccountDaoImpl extends CriteriaDaoImpl<CustomerAccount, Long> implements CustomerAccountDao {

	@Override
	public CustomerAccount findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public CustomerAccount save(CustomerAccount bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public CustomerAccount deleteById(Long id) {
		CustomerAccount entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<CustomerAccount> getEntityClass() {
		return CustomerAccount.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}