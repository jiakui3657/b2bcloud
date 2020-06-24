package com.haoxuer.b2bcloud.finance.api.domain.request;

import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MoneyRequest extends TenantRequest {

    private BigDecimal account;

    private String note;

    private Long user;
}
