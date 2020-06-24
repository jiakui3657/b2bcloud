package com.haoxuer.b2bcloud.order.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "退货商品", add = "退货商品", list = "退货商品", update = "退货商品")
@Entity
@Table(name = "bs_tenant_order_refund_item")
public class OrderRefundItem extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderRefund refund;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderItem orderItem;

    private Integer num;
}
