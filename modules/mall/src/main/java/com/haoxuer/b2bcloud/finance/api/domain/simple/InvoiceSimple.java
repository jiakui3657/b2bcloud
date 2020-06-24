package com.haoxuer.b2bcloud.finance.api.domain.simple;


import java.io.Serializable;
import lombok.Data;

/**
*
* Created by imake on 2020年05月15日17:23:37.
*/

@Data
public class InvoiceSimple implements Serializable {

    private Long id;

     private String address;

     private String phone;

     private String name;

     private String bankNo;

     private String taxNo;

     private String bankName;

}