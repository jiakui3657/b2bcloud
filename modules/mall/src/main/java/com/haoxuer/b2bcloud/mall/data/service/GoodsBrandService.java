package com.haoxuer.b2bcloud.mall.data.service;

import com.haoxuer.b2bcloud.mall.data.entity.GoodsBrand;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2019年12月29日14:17:43.
*/
public interface GoodsBrandService {

	GoodsBrand findById(Long id);

	GoodsBrand save(GoodsBrand bean);

	GoodsBrand update(GoodsBrand bean);

	GoodsBrand deleteById(Long id);
	
	GoodsBrand[] deleteByIds(Long[] ids);
	
	Page<GoodsBrand> page(Pageable pageable);
	
	Page<GoodsBrand> page(Pageable pageable, Object search);


	List<GoodsBrand> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}