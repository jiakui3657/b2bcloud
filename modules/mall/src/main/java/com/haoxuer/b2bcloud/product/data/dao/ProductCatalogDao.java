package com.haoxuer.b2bcloud.product.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.product.data.entity.ProductCatalog;

/**
* Created by imake on 2020年05月07日19:01:34.
*/
public interface ProductCatalogDao extends BaseDao<ProductCatalog,Integer>{

	 ProductCatalog findById(Integer id);

	 ProductCatalog save(ProductCatalog bean);

	 ProductCatalog updateByUpdater(Updater<ProductCatalog> updater);

	 ProductCatalog deleteById(Integer id);

	 ProductCatalog findById(Long tenant, Integer id);

     ProductCatalog deleteById(Long tenant, Integer id);
}