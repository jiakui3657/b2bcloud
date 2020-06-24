package com.haoxuer.b2bcloud.promote.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.b2bcloud.promote.data.entity.PromoteProduct;

/**
* Created by imake on 2020年05月11日14:14:40.
*/
public interface PromoteProductDao extends BaseDao<PromoteProduct,Long>{

	 PromoteProduct findById(Long id);

	 PromoteProduct save(PromoteProduct bean);

	 PromoteProduct updateByUpdater(Updater<PromoteProduct> updater);

	 PromoteProduct deleteById(Long id);

	 PromoteProduct findById(Long tenant, Long id);

     PromoteProduct deleteById(Long tenant, Long id);
}