package com.haoxuer.b2bcloud.order.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderTempSimple implements Serializable {

  private Long id;

  private String name;

  private String logo;

  private Long product;

  private BigDecimal price;

  private Integer num;

  private Integer useNum;

  private Integer surplusNum;

}
