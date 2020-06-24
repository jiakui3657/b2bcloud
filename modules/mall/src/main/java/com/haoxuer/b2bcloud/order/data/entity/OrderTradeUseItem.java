package com.haoxuer.b2bcloud.order.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "订货会使用项", add = "订货会使用项", list = "订货会使用项", update = "订货会使用项")
@Entity
@Table(name = "bs_tenant_order_trade_use_item")
public class OrderTradeUseItem extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderTradeItem item;

    private Integer size;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderTradeUseRecord record;

}
