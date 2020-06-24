package com.haoxuer.b2bcloud.mall.data.entity;


import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "商品属性名称", add = "添加商品属性名称", list = "商品属性名称", update = "更新商品属性名称")
@Entity
@Table(name = "bs_tenant_mall_goods_spu_value")
public class SpuValue  extends TenantEntity {


    /**
     * 商品值
     */
    private String spuValue;

    /**
     * 商品属性名称
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private SpuName spuName;

    /**
     * 商品值状态
     */
    private String status;

}
