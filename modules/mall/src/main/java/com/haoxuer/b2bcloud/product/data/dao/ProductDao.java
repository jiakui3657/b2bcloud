package com.haoxuer.b2bcloud.product.data.dao;


import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.discover.data.core.BaseDao;
import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;

import java.util.List;

/**
* Created by imake on 2020年03月23日16:15:52.
*/
public interface ProductDao extends BaseDao<Product,Long>{

	 Product findById(Long id);

	 Product save(Product bean);

	 Product updateByUpdater(Updater<Product> updater);

	 Product deleteById(Long id);

	Page<Product> page(Pageable pageable, List<Long> tags);

	Product findById(Long tenant, Long id);

	Product deleteById(Long tenant, Long id);

}