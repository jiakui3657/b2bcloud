package com.haoxuer.b2bcloud.mall.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.mall.data.entity.SpuValue;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;

import java.util.List;

/**
* Created by imake on 2019年12月29日13:42:35.
*/
public interface SpuValueDao extends BaseDao<SpuValue,Long>{

	 SpuValue findById(Long id);

	 SpuValue save(SpuValue bean);

	 SpuValue updateByUpdater(Updater<SpuValue> updater);

	 SpuValue deleteById(Long id);

	 List<SpuValue> findlist(int first, Integer size, List<Filter> filters, List<Order> orders);
}