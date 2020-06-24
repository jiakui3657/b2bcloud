package com.haoxuer.b2bcloud.mall.data.service;

import com.haoxuer.b2bcloud.mall.data.entity.GoodsCatalog;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2019年12月29日13:42:18.
*/
public interface GoodsCatalogService {

	GoodsCatalog findById(Integer id);

	GoodsCatalog save(GoodsCatalog bean);

	GoodsCatalog update(GoodsCatalog bean);

	GoodsCatalog deleteById(Integer id);
	
	GoodsCatalog[] deleteByIds(Integer[] ids);
	
	Page<GoodsCatalog> page(Pageable pageable);
	
	Page<GoodsCatalog> page(Pageable pageable, Object search);

	List<GoodsCatalog> findByTops(Integer pid);


    List<GoodsCatalog> child(Integer id,Integer max);

	List<GoodsCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}