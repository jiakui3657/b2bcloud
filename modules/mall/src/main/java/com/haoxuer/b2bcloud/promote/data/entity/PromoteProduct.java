package com.haoxuer.b2bcloud.promote.data.entity;

import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@FormAnnotation(title = "促销商品", add = "促销商品", list = "促销商品", update = "促销商品")
@Entity
@Table(name = "bs_tenant_promote_product")
public class PromoteProduct extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Promote promote;

    private BigDecimal price;
}
