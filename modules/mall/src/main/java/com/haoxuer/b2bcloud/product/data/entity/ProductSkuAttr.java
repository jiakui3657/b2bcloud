package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "商品sku", add = "商品sku", list = "商品sku", update = "商品sku")
@Entity
@Table(name = "bs_tenant_product_sku_attr")
public class ProductSkuAttr extends TenantEntity {

    private String groupName;

    private String attrName;

    private String attrValueCode;

    private String attrValueName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductType productType;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductTypeAttr productTypeAttr;
}
