package com.haoxuer.b2bcloud.mall.data.service;

import com.haoxuer.b2bcloud.mall.data.entity.Goods;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2019年12月29日13:46:48.
*/
public interface GoodsService {

	Goods findById(Long id);

	Goods save(Goods bean);

	Goods update(Goods bean);

	Goods deleteById(Long id);
	
	Goods[] deleteByIds(Long[] ids);
	
	Page<Goods> page(Pageable pageable);
	
	Page<Goods> page(Pageable pageable, Object search);


	List<Goods> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}