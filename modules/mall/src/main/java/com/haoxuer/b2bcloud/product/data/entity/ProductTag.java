package com.haoxuer.b2bcloud.product.data.entity;


import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "商品标签", add = "商品标签", list = "商品标签", update = "商品标签")
@Entity
@Table(name = "bs_tenant_product_tag")
public class ProductTag extends TenantEntity {

    @Column(length = 50)
    private String name;
}
