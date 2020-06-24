package com.haoxuer.b2bcloud.promote.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月06日21:50:05.
*/

@Data
public class CouponDeleteRequest extends TenantRequest {

    private Long id;

}