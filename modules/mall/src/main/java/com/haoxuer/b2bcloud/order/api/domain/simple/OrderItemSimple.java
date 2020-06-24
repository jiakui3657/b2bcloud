package com.haoxuer.b2bcloud.order.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderItemSimple implements Serializable {

  private Long id;

  private String name;

  private String logo;

  private BigDecimal price;

  private Integer num;

  private Integer surplusNum;

  private Integer returnNum;

  //零时变量
  private Integer tempNum;

}
