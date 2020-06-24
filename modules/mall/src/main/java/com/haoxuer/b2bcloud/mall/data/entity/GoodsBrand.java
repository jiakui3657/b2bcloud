package com.haoxuer.b2bcloud.mall.data.entity;


import com.haoxuer.bigworld.tenant.data.entity.TenantCatalogEntity;
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
@FormAnnotation(title = "品牌属性", add = "添加品牌属性", list = "品牌属性", update = "更新品牌属性")
@Entity
@Table(name = "bs_tenant_mall_goods_brand")
public class GoodsBrand  extends TenantEntity {

    @FormFieldAnnotation(title = "品牌名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String name;
    @FormFieldAnnotation(title = "品牌logo", sortNum = "2", grid = true, col = ColType.col_2)
    private String logo;
    @FormFieldAnnotation(title = "状态", sortNum = "2", grid = true, col = ColType.col_2)
    private String status;

}
