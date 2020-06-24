package com.haoxuer.b2bcloud.product.api.domain.request;

import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

@Data
public class  ProductSpecValueAddRequest extends TenantRequest {

    private Long id;

    private String name;

    private Integer sortNum;
}
