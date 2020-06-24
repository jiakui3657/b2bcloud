package com.haoxuer.b2bcloud.customer.data.dao;


import com.haoxuer.discover.data.core.BaseDao;
import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.customer.data.entity.ShopCart;

/**
 * Created by imake on 2020年05月23日19:44:59.
 */
public interface ShopCartDao extends BaseDao<ShopCart, Long> {

    ShopCart findById(Long id);

    ShopCart save(ShopCart bean);

    ShopCart updateByUpdater(Updater<ShopCart> updater);

    ShopCart deleteById(Long id);

    ShopCart findById(Long tenant, Long id);

    ShopCart deleteById(Long tenant, Long id);

    ShopCart findByUser(Long user,Long tenant);
}