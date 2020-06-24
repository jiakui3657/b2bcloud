package com.haoxuer.b2bcloud.customer.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年05月23日19:44:59.
*/

@Data
public class ShopCartResponse extends ResponseObject {

    private Long id;

     private Integer num;

     private Integer userId;

}