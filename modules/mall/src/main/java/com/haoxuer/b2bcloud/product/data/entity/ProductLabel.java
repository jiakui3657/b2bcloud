package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.enums.StoreState;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "商品标签", add = "商品标签", list = "商品标签", update = "商品标签")
@Entity
@Table(name = "bs_tenant_product_label")
public class ProductLabel extends TenantEntity {

    @FormFieldAnnotation(title = "标签名称", sortNum = "1", grid = true, col = ColType.col_2)
    @Column(length = 50)
    private String name;

    private StoreState storeState;

    private Integer sortNum;

}
