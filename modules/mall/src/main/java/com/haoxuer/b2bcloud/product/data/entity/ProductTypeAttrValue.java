package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.b2bcloud.store.data.entity.Store;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "商品规格属性值表", add = "商品规格属性值表", list = "商品规格属性值表", update = "商品规格属性值表")
@Entity
@Table(name = "bs_tenant_product_type_value")
public class ProductTypeAttrValue extends TenantEntity {

    private Short attrType;
    private String attrValue;

    private String attrCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductTypeAttr attr;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

}
