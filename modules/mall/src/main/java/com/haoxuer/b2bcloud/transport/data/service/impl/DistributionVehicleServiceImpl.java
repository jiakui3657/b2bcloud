package com.haoxuer.b2bcloud.transport.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.transport.data.dao.DistributionVehicleDao;
import com.haoxuer.b2bcloud.transport.data.entity.DistributionVehicle;
import com.haoxuer.b2bcloud.transport.data.service.DistributionVehicleService;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import com.haoxuer.discover.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2020年03月21日16:54:32.
*/


@Scope("prototype")
@Service
@Transactional
public class DistributionVehicleServiceImpl implements DistributionVehicleService {

	private DistributionVehicleDao dao;


	@Override
	@Transactional(readOnly = true)
	public DistributionVehicle findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public DistributionVehicle save(DistributionVehicle bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public DistributionVehicle update(DistributionVehicle bean) {
		Updater<DistributionVehicle> updater = new Updater<DistributionVehicle>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public DistributionVehicle deleteById(Long id) {
		DistributionVehicle bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public DistributionVehicle[] deleteByIds(Long[] ids) {
		DistributionVehicle[] beans = new DistributionVehicle[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(DistributionVehicleDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<DistributionVehicle> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<DistributionVehicle> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<DistributionVehicle> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}