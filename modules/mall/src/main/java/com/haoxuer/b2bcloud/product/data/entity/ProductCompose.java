package com.haoxuer.b2bcloud.product.data.entity;


//赠品或配件推荐商品组合表

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "商品包", add = "商品包", list = "商品包", update = "商品包")
@Entity
@Table(name = "bs_tenant_product_compose")
public  class ProductCompose extends TenantEntity {

    //关联关系。1赠品 2配件 3推荐组合
    private Integer composeType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product composeProduct;
}
