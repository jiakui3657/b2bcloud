package com.haoxuer.b2bcloud.finance.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.finance.data.dao.FinanceAccountDao;
import com.haoxuer.b2bcloud.finance.data.entity.FinanceAccount;

/**
* Created by imake on 2020年04月13日17:52:21.
*/
@Repository

public class FinanceAccountDaoImpl extends CriteriaDaoImpl<FinanceAccount, Long> implements FinanceAccountDao {

	@Override
	public FinanceAccount findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public FinanceAccount save(FinanceAccount bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public FinanceAccount deleteById(Long id) {
		FinanceAccount entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<FinanceAccount> getEntityClass() {
		return FinanceAccount.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}