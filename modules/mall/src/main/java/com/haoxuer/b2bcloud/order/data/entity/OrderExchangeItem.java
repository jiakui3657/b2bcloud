package com.haoxuer.b2bcloud.order.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "换货商品", add = "换货商品", list = "换货商品", update = "换货商品")
@Entity
@Table(name = "bs_tenant_order_exchange_item")
public class OrderExchangeItem extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderExchange exchange;

    private Integer num;
}
