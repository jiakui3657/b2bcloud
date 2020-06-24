package com.haoxuer.b2bcloud.mall.data.service;

import com.haoxuer.b2bcloud.mall.data.entity.GoodsSkuSpu;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年01月17日14:09:33.
*/
public interface GoodsSkuSpuService {

	GoodsSkuSpu findById(Long id);

	GoodsSkuSpu save(GoodsSkuSpu bean);

	GoodsSkuSpu update(GoodsSkuSpu bean);

	GoodsSkuSpu deleteById(Long id);
	
	GoodsSkuSpu[] deleteByIds(Long[] ids);
	
	Page<GoodsSkuSpu> page(Pageable pageable);
	
	Page<GoodsSkuSpu> page(Pageable pageable, Object search);


	List<GoodsSkuSpu> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}