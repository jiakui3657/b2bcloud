package com.haoxuer.b2bcloud.purchase.api.domain.simple;


import java.io.Serializable;
import lombok.Data;

/**
*
* Created by imake on 2020年05月12日19:55:07.
*/

@Data
public class SupplierSimple implements Serializable {

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