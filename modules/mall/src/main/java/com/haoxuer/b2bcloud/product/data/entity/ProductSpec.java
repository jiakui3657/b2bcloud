package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@FormAnnotation(title = "商品规格", add = "商品规格", list = "商品规格", update = "商品规格")
@Entity
@Table(name = "bs_tenant_product_spec")
public class ProductSpec extends TenantEntity {

    @FormFieldAnnotation(title = "规格名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String name;

    @FormFieldAnnotation(title = "排序号", sortNum = "1", grid = true, col = ColType.col_2)
    private Integer sortNum;

    @OrderBy(" sortNum asc ")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "spec")
    private List<ProductSpecValue> specs;

}
