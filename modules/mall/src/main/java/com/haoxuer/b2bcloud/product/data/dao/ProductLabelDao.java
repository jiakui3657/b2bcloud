package com.haoxuer.b2bcloud.product.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.product.data.entity.ProductLabel;

/**
* Created by imake on 2020年05月06日22:17:46.
*/
public interface ProductLabelDao extends BaseDao<ProductLabel,Long>{

	 ProductLabel findById(Long id);

	 ProductLabel save(ProductLabel bean);

	 ProductLabel updateByUpdater(Updater<ProductLabel> updater);

	 ProductLabel deleteById(Long id);

	 ProductLabel findById(Long tenant, Long id);

     ProductLabel deleteById(Long tenant, Long id);
}