package com.haoxuer.b2bcloud.product.data.service;

import com.haoxuer.b2bcloud.product.data.entity.ProductLabel;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月06日22:17:46.
*/
public interface ProductLabelService {

	ProductLabel findById(Long id);

	ProductLabel save(ProductLabel bean);

	ProductLabel update(ProductLabel bean);

	ProductLabel deleteById(Long id);
	
	ProductLabel[] deleteByIds(Long[] ids);
	
	Page<ProductLabel> page(Pageable pageable);
	
	Page<ProductLabel> page(Pageable pageable, Object search);


	List<ProductLabel> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	ProductLabel findById(Long tenant, Long id);

    ProductLabel deleteById(Long tenant, Long id);

}