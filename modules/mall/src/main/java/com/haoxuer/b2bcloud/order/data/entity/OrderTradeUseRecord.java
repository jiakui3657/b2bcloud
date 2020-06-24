package com.haoxuer.b2bcloud.order.data.entity;

import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "订货会订单", add = "订货会订单", list = "订货会订单", update = "订货会订单")
@Entity
@Table(name = "bs_tenant_order_trade_use_record")
public class OrderTradeUseRecord extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderTrade trade;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderData orderData;

    private Integer size;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

}
