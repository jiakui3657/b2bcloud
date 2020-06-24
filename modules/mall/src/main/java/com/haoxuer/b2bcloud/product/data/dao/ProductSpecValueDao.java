package com.haoxuer.b2bcloud.product.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.product.data.entity.ProductSpecValue;

/**
* Created by imake on 2020年04月15日19:43:49.
*/
public interface ProductSpecValueDao extends BaseDao<ProductSpecValue,Long>{

	 ProductSpecValue findById(Long id);

	 ProductSpecValue save(ProductSpecValue bean);

	 ProductSpecValue updateByUpdater(Updater<ProductSpecValue> updater);

	 ProductSpecValue deleteById(Long id);
}