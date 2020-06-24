package com.haoxuer.b2bcloud.customer.api.domain.simple;


import java.io.Serializable;
import lombok.Data;

/**
*
* Created by imake on 2020年05月09日15:47:39.
*/

@Data
public class CustomerTagSimple implements Serializable {

    private Long id;

     private Long num;

     private String name;

}