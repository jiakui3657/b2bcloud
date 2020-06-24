package com.haoxuer.b2bcloud.product.data.service;

import com.haoxuer.b2bcloud.order.vo.ProductVo;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年03月23日16:15:52.
*/
public interface ProductService {

	/**
	 * 上线产品
	 * @param id
	 * @return
	 */
	Product online(Long id);

	/**
	 * 下线产品
	 * @param id
	 * @return
	 */
	Product offline(Long id);


	Product findById(Long id);

	Product save(Product bean);

	Product update(Product bean);

	Product deleteById(Long id);
	
	Product[] deleteByIds(Long[] ids);
	
	Page<Product> page(Pageable pageable);
	
	Page<Product> page(Pageable pageable, Object search);

	Page<Product> page(Pageable pageable, Object search, List<Long> tags);

	List<Product> list(int first, Integer size, List<Filter> filters, List<Order> orders);

    void updates(List<ProductVo> vos);
}