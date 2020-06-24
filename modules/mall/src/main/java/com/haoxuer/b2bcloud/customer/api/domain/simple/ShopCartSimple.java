package com.haoxuer.b2bcloud.customer.api.domain.simple;


import java.io.Serializable;
import lombok.Data;

/**
*
* Created by imake on 2020年05月23日19:44:59.
*/

@Data
public class ShopCartSimple implements Serializable {

    private Long id;

     private Integer num;

     private Integer userId;

}