package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "分类导航表", add = "分类导航表", list = "分类导航表", update = "分类导航表")
@Entity
@Table(name = "bs_tenant_product_category_nav")
public class ProductCategoryNav extends TenantEntity {

    //顶级分类导航推荐id集(多个逗号分隔)
    private String topCateIds;
    //分类推荐id集(多个逗号分隔)
    private String subCateIds;

    //品牌推荐(多个逗号分隔)
    private String brandIds;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductCatalog category;

}
