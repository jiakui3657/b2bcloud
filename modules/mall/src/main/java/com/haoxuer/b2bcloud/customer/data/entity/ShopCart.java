package com.haoxuer.b2bcloud.customer.data.entity;

import com.haoxuer.bigworld.member.data.entity.TenantUser;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@FormAnnotation(title = "购物车", add = "购物车", list = "购物车", update = "购物车")
@Entity
@Table(name = "bs_tenant_mall_customer_shop_cart")
public class ShopCart extends TenantEntity {


    public static ShopCart fromId(Long id) {
        ShopCart result = new ShopCart();
        result.setId(id);
        return result;
    }

    private Integer num;

    @ManyToOne(fetch = FetchType.LAZY)
    private TenantUser user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
    private List<ShopCartItem> items;
}
