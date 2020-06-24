package com.haoxuer.b2bcloud.product.data.service;

import com.haoxuer.b2bcloud.product.data.entity.ProductSpecValue;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年04月15日19:43:49.
*/
public interface ProductSpecValueService {

	ProductSpecValue findById(Long id);

	ProductSpecValue save(ProductSpecValue bean);

	ProductSpecValue update(ProductSpecValue bean);

	ProductSpecValue deleteById(Long id);
	
	ProductSpecValue[] deleteByIds(Long[] ids);
	
	Page<ProductSpecValue> page(Pageable pageable);
	
	Page<ProductSpecValue> page(Pageable pageable, Object search);


	List<ProductSpecValue> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}