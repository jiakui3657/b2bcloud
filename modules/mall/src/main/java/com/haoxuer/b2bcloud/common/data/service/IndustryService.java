package com.haoxuer.b2bcloud.common.data.service;

import com.haoxuer.b2bcloud.common.data.entity.Industry;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月07日14:03:56.
*/
public interface IndustryService {

	Industry findById(Integer id);

	Industry save(Industry bean);

	Industry update(Industry bean);

	Industry deleteById(Integer id);
	
	Industry[] deleteByIds(Integer[] ids);
	
	Page<Industry> page(Pageable pageable);
	
	Page<Industry> page(Pageable pageable, Object search);

	List<Industry> findByTops(Integer pid);


    List<Industry> child(Integer id,Integer max);

	List<Industry> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	Industry findById(Long tenant, Integer id);

    Industry deleteById(Long tenant, Integer id);

}