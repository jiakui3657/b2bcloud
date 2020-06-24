package com.haoxuer.b2bcloud.product.data.service;

import com.haoxuer.b2bcloud.product.data.entity.ProductCatalog;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年05月07日19:01:34.
*/
public interface ProductCatalogService {

	ProductCatalog findById(Integer id);

	ProductCatalog save(ProductCatalog bean);

	ProductCatalog update(ProductCatalog bean);

	ProductCatalog deleteById(Integer id);
	
	ProductCatalog[] deleteByIds(Integer[] ids);
	
	Page<ProductCatalog> page(Pageable pageable);
	
	Page<ProductCatalog> page(Pageable pageable, Object search);

	List<ProductCatalog> findByTops(Integer pid);


    List<ProductCatalog> child(Integer id,Integer max);

	List<ProductCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	ProductCatalog findById(Long tenant, Integer id);

    ProductCatalog deleteById(Long tenant, Integer id);

}