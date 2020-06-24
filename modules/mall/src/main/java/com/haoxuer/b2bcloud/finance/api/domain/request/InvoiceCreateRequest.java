package com.haoxuer.b2bcloud.finance.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月15日17:23:37.
*/

@Data
public class InvoiceCreateRequest extends TenantRequest {


     private String address;

     private String phone;

     private String name;

     private String bankNo;

     private String taxNo;

     private String bankName;


}