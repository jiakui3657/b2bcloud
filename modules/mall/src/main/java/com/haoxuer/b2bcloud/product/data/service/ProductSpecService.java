package com.haoxuer.b2bcloud.product.data.service;

import com.haoxuer.b2bcloud.product.data.entity.ProductSpec;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年04月15日19:22:54.
*/
public interface ProductSpecService {

	ProductSpec findById(Long id);

	ProductSpec save(ProductSpec bean);

	ProductSpec update(ProductSpec bean);

	ProductSpec deleteById(Long id);
	
	ProductSpec[] deleteByIds(Long[] ids);
	
	Page<ProductSpec> page(Pageable pageable);
	
	Page<ProductSpec> page(Pageable pageable, Object search);


	List<ProductSpec> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}