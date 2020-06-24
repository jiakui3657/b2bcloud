package com.haoxuer.b2bcloud.customer.data.entity;

import com.haoxuer.b2bcloud.order.data.entity.OrderTradeItem;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.b2bcloud.product.data.entity.ProductSku;
import com.haoxuer.b2bcloud.store.data.entity.Store;
import com.haoxuer.bigworld.member.data.entity.TenantUser;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@FormAnnotation(title = "购物车子项", add = "购物车子项", list = "购物车子项", update = "购物车子项")
@Entity
@Table(name = "bs_tenant_mall_customer_shop_cart_item")
public class ShopCartItem extends TenantEntity {

    private BigDecimal price;

    private Integer size;

    private BigDecimal total;

    @ManyToOne(fetch = FetchType.LAZY)
    private ShopCart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    private TenantUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductSku sku;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    private Boolean trade;

    //订货会中的商品id
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderTradeItem item;
}
