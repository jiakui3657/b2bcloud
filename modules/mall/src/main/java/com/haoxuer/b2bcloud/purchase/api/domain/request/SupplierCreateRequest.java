package com.haoxuer.b2bcloud.purchase.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年05月12日19:55:07.
*/

@Data
public class SupplierCreateRequest extends TenantRequest {


     private String shop;

     private String note;

     private String address;

     private Double lng;

     private String phone;

     private String name;

     private String tel;

     private Double lat;


}