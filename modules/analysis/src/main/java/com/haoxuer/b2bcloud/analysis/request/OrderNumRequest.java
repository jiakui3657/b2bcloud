package com.haoxuer.b2bcloud.analysis.request;

import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

import java.util.Date;

@Data
public class OrderNumRequest extends TenantRequest {

    private Date beginDate;

    private Date endDate;

}
