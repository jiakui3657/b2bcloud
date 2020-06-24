package com.haoxuer.b2bcloud.mall.data.entity;

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
@FormAnnotation(title = "商品", add = "添加商品", list = "商品", update = "更新商品")
@Entity
@Table(name = "bs_tenant_mall_goods")
public class Goods extends TenantEntity {

    @FormFieldAnnotation(title = "商品名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String name;

    /**
     * 商品编码
     */
    @FormFieldAnnotation(title = "商品编码", sortNum = "2", grid = true, col = ColType.col_2)
    private String code;


    /**
     * 所属品牌
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private GoodsBrand brand;


    /**
     * 所属商户
     */
    private String merchant;

    /**
     * 单位
     */
    private String unit;

    /**
     * 标签
     */
    private String label;


    /**
     * 图片
     */
    private String img;


    /**
     * 状态
     * 0为下架 1为上架
     */
    private String status;

    /**
     * 所属分类
     */
    @FormFieldAnnotation(title = "所属分类", sortNum = "3", grid = true, col = ColType.col_2)
    @ManyToOne(fetch = FetchType.LAZY)
    private GoodsCatalog catalog;




    /**
     * 描述信息
     */
    @FormFieldAnnotation(title = "描述信息", sortNum = "4", grid = false, col = ColType.col_2)
    private String note;


}
