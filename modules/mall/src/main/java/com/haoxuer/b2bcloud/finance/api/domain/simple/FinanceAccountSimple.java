package com.haoxuer.b2bcloud.finance.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class FinanceAccountSimple implements Serializable {

    private Long id;

    private String name;

    private String no;

    private String shop;

    private String phone;

    private Long accountNo;

    private BigDecimal account;

    private BigDecimal credit;
}
