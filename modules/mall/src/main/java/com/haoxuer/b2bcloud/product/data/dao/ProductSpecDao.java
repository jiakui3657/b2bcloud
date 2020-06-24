package com.haoxuer.b2bcloud.product.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.product.data.entity.ProductSpec;

/**
* Created by imake on 2020年04月15日19:22:54.
*/
public interface ProductSpecDao extends BaseDao<ProductSpec,Long>{

	 ProductSpec findById(Long id);

	 ProductSpec save(ProductSpec bean);

	 ProductSpec updateByUpdater(Updater<ProductSpec> updater);

	 ProductSpec deleteById(Long id);
}