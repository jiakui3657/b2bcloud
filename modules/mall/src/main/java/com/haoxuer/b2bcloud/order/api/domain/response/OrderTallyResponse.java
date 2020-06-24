package com.haoxuer.b2bcloud.order.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年06月04日16:56:41.
*/

@Data
public class OrderTallyResponse extends ResponseObject {

    private Long id;

     private String no;

     private String consignee;

     private String note;

     private String address;

     private String phone;

     private String state;

}