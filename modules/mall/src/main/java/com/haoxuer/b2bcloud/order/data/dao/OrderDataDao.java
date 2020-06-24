package com.haoxuer.b2bcloud.order.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.discover.data.page.Filter;

import java.math.BigDecimal;
import java.util.List;

/**
* Created by imake on 2020年05月08日10:28:40.
*/
public interface OrderDataDao extends BaseDao<OrderData,Long>{

	 OrderData findById(Long id);

	 OrderData save(OrderData bean);

	 OrderData updateByUpdater(Updater<OrderData> updater);

	 OrderData deleteById(Long id);

	 OrderData findById(Long tenant, Long id);

     OrderData deleteById(Long tenant, Long id);

	BigDecimal sum(List<Filter> filters);

}