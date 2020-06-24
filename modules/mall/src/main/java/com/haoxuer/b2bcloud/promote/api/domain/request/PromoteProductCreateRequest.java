package com.haoxuer.b2bcloud.promote.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月11日14:14:40.
*/

@Data
public class PromoteProductCreateRequest extends TenantRequest {


   private Long product;

   private Long promote;

}