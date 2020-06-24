package com.haoxuer.b2bcloud.order.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProductSimple implements Serializable {


    private Long id;

    private String name;

    private String logo;

    private Integer num;

    private Integer catalog;

    private BigDecimal price;

    private String unit;

    private boolean fav;

    private String demo;

}
