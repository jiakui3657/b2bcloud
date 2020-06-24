package com.haoxuer.b2bcloud.store.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月02日15:43:56.
*/

@Data
public class StoreUpdateRequest extends TenantRequest {

    private Long id;

    private String name;

}