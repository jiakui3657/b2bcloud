package com.haoxuer.b2bcloud.transport.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.transport.data.dao.VehicleTypeDao;
import com.haoxuer.b2bcloud.transport.data.entity.VehicleType;
import com.haoxuer.b2bcloud.transport.data.service.VehicleTypeService;

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
* Created by imake on 2020年03月21日16:54:10.
*/


@Scope("prototype")
@Service
@Transactional
public class VehicleTypeServiceImpl implements VehicleTypeService {

	private VehicleTypeDao dao;


	@Override
	@Transactional(readOnly = true)
	public VehicleType findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public VehicleType save(VehicleType bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public VehicleType update(VehicleType bean) {
		Updater<VehicleType> updater = new Updater<VehicleType>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public VehicleType deleteById(Long id) {
		VehicleType bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public VehicleType[] deleteByIds(Long[] ids) {
		VehicleType[] beans = new VehicleType[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(VehicleTypeDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<VehicleType> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<VehicleType> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<VehicleType> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}