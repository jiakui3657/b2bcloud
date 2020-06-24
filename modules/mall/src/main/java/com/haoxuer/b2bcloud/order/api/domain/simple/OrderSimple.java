package com.haoxuer.b2bcloud.order.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderSimple implements Serializable {

    private Long id;

    private String date;

    private BigDecimal money;

    private String no;

    private String note;
}
