package com.haoxuer.b2bcloud.finance.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年05月15日17:23:37.
*/

@Data
public class InvoiceResponse extends ResponseObject {

    private Long id;

     private String address;

     private String phone;

     private String name;

     private String bankNo;

     private String taxNo;

     private String bankName;

}