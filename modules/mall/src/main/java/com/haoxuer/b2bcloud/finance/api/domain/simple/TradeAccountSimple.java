package com.haoxuer.b2bcloud.finance.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TradeAccountSimple implements Serializable {

    private Long id;

    private BigDecimal money;

    private String name;
}
