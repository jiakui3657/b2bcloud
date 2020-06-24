package com.haoxuer.b2bcloud.customer.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月09日15:47:39.
*/

@Data
public class CustomerTagCreateRequest extends TenantRequest {


     private Long num;

     private String name;


}