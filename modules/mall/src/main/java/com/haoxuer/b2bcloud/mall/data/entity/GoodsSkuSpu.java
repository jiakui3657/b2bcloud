package com.haoxuer.b2bcloud.mall.data.entity;


import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "商品SKU_SPU", add = "添加商品SKU_SPU", list = "商品SKU_SPU", update = "更新商品SKU_SPU")
@Entity
@Table(name = "bs_tenant_mall_goods_sku_spu")
public class GoodsSkuSpu  extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private GoodsSku goodsSku;
    @ManyToOne(fetch = FetchType.LAZY)
    private SpuValue spuValue;
}
