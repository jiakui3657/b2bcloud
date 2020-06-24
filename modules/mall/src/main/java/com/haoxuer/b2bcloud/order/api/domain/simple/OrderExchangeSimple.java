package com.haoxuer.b2bcloud.order.api.domain.simple;


import java.io.Serializable;
import lombok.Data;

/**
*
* Created by imake on 2020年05月12日18:42:46.
*/

@Data
public class OrderExchangeSimple implements Serializable {

    private Long id;

     private String no;

     private String name;

     private String state;

}