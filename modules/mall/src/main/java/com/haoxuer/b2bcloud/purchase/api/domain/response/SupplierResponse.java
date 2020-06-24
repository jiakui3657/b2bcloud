package com.haoxuer.b2bcloud.purchase.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年05月12日19:55:07.
*/

@Data
public class SupplierResponse extends ResponseObject {

    private Long id;

     private String shop;

     private String note;

     private String address;

     private Double lng;

     private String phone;

     private String name;

     private String tel;

     private Double lat;

}