package com.haoxuer.b2bcloud.mall.data.entity;


import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@FormAnnotation(title = "商品SKU", add = "添加商品SKU", list = "商品SKU", update = "更新商品SKU")
@Entity
@Table(name = "bs_tenant_mall_goods_sku")
public class GoodsSku  extends TenantEntity {

    /**
     *  sku编号,唯一
     *
     * */
    private String skuNo;
    /**
     *  sku名称(冗余spu_name)
     *
     * */
    private String skuName;

    /**
     *   售价
     *
     * */
    private String price;
    /**
     *   库存
     *
     * */
    private String stock;

    /**
     *
     * good_id
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Goods goods;

    /**
     *
     * good_id
     *
     */
    private String spuNameId;
    /**
     *
     * spu_id
     *
     */
    private String spuValueId;

}
