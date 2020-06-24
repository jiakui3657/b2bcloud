package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "行业状态统计表", add = "行业状态统计表", list = "行业状态统计表", update = "行业状态统计表")
@Entity
@Table(name = "bs_tenant_product_category_statistics")
public class ProductCategoryStatistics extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductCatalog category;

    //行业店铺商品平均评分
    private Float productScore;
    //行业店铺平均发货速度
    private Float consignmentScore;

    //行业店铺平均服务态度
    private Float serviceScore;
}
