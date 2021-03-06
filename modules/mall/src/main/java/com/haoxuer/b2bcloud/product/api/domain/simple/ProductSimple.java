package com.haoxuer.b2bcloud.product.api.domain.simple;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

/**
*
* Created by imake on 2020年04月28日13:38:35.
*/

@Data
public class ProductSimple implements Serializable {

    private Long id;

    //名称
    private String name;

    //编码
    private String barCode;

    //分类
    private String catalog;

    //销售价格
    private BigDecimal salePrice;

    //vip价格
    private BigDecimal vipPrice;

    private BigDecimal price;

    //市场价格
    private BigDecimal marketPrice;

    //库存
    private Integer inventory;

    //商品图片
    private String logo;



    private Integer num;

    private String unit;

    private String demo;

    private List<ProductSkuSimple> skus;

    private String state;


}