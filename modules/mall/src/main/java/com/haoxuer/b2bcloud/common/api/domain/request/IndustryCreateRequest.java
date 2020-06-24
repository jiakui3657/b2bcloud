package com.haoxuer.b2bcloud.common.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月07日14:03:56.
*/

@Data
public class IndustryCreateRequest extends TenantRequest {

    private String name;

}