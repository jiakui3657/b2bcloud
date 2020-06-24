package com.haoxuer.b2bcloud.order.data.entity;

import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@FormAnnotation(title = "订货会订货商品", add = "订货会订货商品", list = "订货会订货商品", update = "订货会订货商品")
@Entity
@Table(name = "bs_tenant_order_trade_item")
public class OrderTradeItem extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderTrade trade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    //购买数量
    private Integer size;

    //使用数量
    private Integer useNum;

    //剩余
    private Integer surplusNum;

    //价格锁定
    private BigDecimal price;

    //商品名称
    private String name;

    //商品图片
    private String logo;
}
