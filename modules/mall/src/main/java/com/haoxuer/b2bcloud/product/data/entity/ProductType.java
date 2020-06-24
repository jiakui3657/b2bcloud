package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Data
@FormAnnotation(title = "商品类型表", add = "商品类型表", list = "商品类型表", update = "商品类型表")
@Entity
@Table(name = "bs_tenant_product_type")
public class ProductType extends TenantEntity {

    private String groupName;

    private Boolean custom;

    private String name;

    @OneToMany(mappedBy = "type",fetch = FetchType.LAZY)
    private List<ProductTypeAttr> typeAttrList;
}
