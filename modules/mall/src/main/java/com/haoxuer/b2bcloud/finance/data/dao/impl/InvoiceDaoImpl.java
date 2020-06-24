package com.haoxuer.b2bcloud.finance.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.finance.data.dao.InvoiceDao;
import com.haoxuer.b2bcloud.finance.data.entity.Invoice;

/**
* Created by imake on 2020年05月15日17:23:36.
*/
@Repository

public class InvoiceDaoImpl extends CriteriaDaoImpl<Invoice, Long> implements InvoiceDao {

	@Override
	public Invoice findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Invoice save(Invoice bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Invoice deleteById(Long id) {
		Invoice entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Invoice> getEntityClass() {
		return Invoice.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public Invoice findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public Invoice deleteById(Long tenant,Long id) {
		Invoice entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}