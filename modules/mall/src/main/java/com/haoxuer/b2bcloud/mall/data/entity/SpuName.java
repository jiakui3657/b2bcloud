package com.haoxuer.b2bcloud.mall.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.*;

@Data
@FormAnnotation(title = "商品规格名称", add = "添加商品规格名称", list = "商品规格名称", update = "更新商品规格名称")
@Entity
@Table(name = "bs_tenant_mall_goods_spu_name")
public class SpuName  extends TenantEntity {

    /**
     * 商品规格名称
     */
    @FormFieldAnnotation(title = "商品规格名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String spuName;

    /**
     * 商品规格状态
     */
    @FormFieldAnnotation(title = "商品规格状态", sortNum = "2", grid = true, col = ColType.col_2)
    private String status;

    /**
     * 是否是输入属性
     */
    @FormFieldAnnotation(title = "是否输入", sortNum = "3", grid = true, col = ColType.col_2)
    private int isInput;

    /**
     * 是否是颜色
     */
    @FormFieldAnnotation(title = "是否颜色", sortNum = "4", grid = true, col = ColType.col_2)
    private int isColor;

    /**
     * 是否是关键字
     */
    @FormFieldAnnotation(title = "是否关键字", sortNum = "5", grid = true, col = ColType.col_2)
    private int isCrux;





}
