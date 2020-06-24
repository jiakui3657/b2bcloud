package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@FormAnnotation(title = "商品sku", add = "商品sku", list = "商品sku", update = "商品sku")
@Entity
@Table(name = "bs_tenant_product_sku")
public class ProductSku extends TenantEntity {


    private String code;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

    private BigDecimal costPrice;

    private Integer inventory;

    private Integer warning;

    private String name;

    private String logo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
