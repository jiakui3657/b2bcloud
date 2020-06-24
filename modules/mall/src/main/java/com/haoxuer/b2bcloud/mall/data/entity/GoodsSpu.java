package com.haoxuer.b2bcloud.mall.data.entity;


import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "商品属性", add = "添加商品属性", list = "商品属性", update = "更新商品属性")
@Entity
@Table(name = "bs_tenant_mall_goods_spu")
public class GoodsSpu  extends TenantEntity {


    /**
     * 商品属性状态
     */
    private String status;

    /**
     * 商品规格名称
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private SpuName spuName;

    /**
     * 商品规格值
     */

    @ManyToOne(fetch = FetchType.LAZY)
    private SpuValue spuValue;


    /**
     * 商品分类
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private GoodsCatalog catalog;
}
