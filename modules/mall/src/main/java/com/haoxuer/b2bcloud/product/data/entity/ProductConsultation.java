package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "商品咨询", add = "商品咨询", list = "商品咨询", update = "商品咨询")
@Entity
@Table(name = "bs_tenant_product_consultation")
public class ProductConsultation  extends TenantEntity {

    private String note;

    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

}
