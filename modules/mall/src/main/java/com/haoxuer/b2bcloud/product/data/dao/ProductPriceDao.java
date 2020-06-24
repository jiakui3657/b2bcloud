package com.haoxuer.b2bcloud.product.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.product.data.entity.ProductPrice;

/**
* Created by imake on 2020年03月30日16:56:18.
*/
public interface ProductPriceDao extends BaseDao<ProductPrice,Long>{

	 ProductPrice findById(Long id);

	 ProductPrice save(ProductPrice bean);

	 ProductPrice updateByUpdater(Updater<ProductPrice> updater);

	 ProductPrice deleteById(Long id);
}