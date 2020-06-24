package com.haoxuer.b2bcloud.order.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年05月09日23:00:47.
*/

@Data
public class OrderRefundResponse extends ResponseObject {

    private Long id;

     private String no;

     private String phone;

     private String name;

}