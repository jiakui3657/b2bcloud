package com.haoxuer.b2bcloud.order.data.dao;


import com.haoxuer.discover.data.core.BaseDao;
import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.order.data.entity.OrderItem;

import java.util.List;

/**
 * Created by imake on 2020年03月30日15:27:08.
 */
public interface OrderItemDao extends BaseDao<OrderItem, Long> {

    OrderItem findById(Long id);

    List<OrderItem> listByUser(Long user, Long product);

    OrderItem save(OrderItem bean);

    OrderItem updateByUpdater(Updater<OrderItem> updater);

    OrderItem deleteById(Long id);
}