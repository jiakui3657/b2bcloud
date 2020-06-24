package com.haoxuer.b2bcloud.customer.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月23日19:44:59.
*/

@Data
public class ShopCartCreateRequest extends TenantRequest {


     private Integer num;

     private Integer userId;


}