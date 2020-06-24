package com.haoxuer.b2bcloud.product.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProductSkuSimple implements Serializable {

    private Long id;

    private String code;

    private String name;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

    private BigDecimal costPrice;

    private Integer inventory;

    private Integer warning;

    private String logo;

}
