package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "商品信息", add = "商品信息", list = "商品信息", update = "商品信息")
@Entity
@Table(name = "bs_tenant_product")
public class ProductAttr extends TenantEntity {

    @FormFieldAnnotation(title = "商品类型属性组名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String groupName;

    @FormFieldAnnotation(title = "商品规格属性名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String attrName;

    @FormFieldAnnotation(title = "商品规格属性值code或输入值", sortNum = "1", grid = true, col = ColType.col_2)
    private String attrValue;

    private Integer proTypeAttrId;

    private Integer productTypeId;

    @FormFieldAnnotation(title = "商品类型", sortNum = "1", grid = true, col = ColType.col_2)
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductType productType;

    @FormFieldAnnotation(title = "所属商品", sortNum = "1", grid = true, col = ColType.col_2)
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @FormFieldAnnotation(title = "商品规格属性", sortNum = "1", grid = true, col = ColType.col_2)
    private ProductTypeAttr productTypeAttr;

}
