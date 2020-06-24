package com.haoxuer.b2bcloud.customer.data.dao;


import com.haoxuer.discover.data.core.BaseDao;
import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.customer.data.entity.ShopCartItem;

/**
 * Created by imake on 2020年05月23日19:44:59.
 */
public interface ShopCartItemDao extends BaseDao<ShopCartItem, Long> {

    ShopCartItem findById(Long id);

    ShopCartItem save(ShopCartItem bean);

    ShopCartItem updateByUpdater(Updater<ShopCartItem> updater);

    ShopCartItem deleteById(Long id);

    ShopCartItem findById(Long tenant, Long id);

    ShopCartItem deleteById(Long tenant, Long id);

    ShopCartItem findByCart(Long cart, Long product);
}