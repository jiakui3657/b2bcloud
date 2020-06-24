package com.haoxuer.b2bcloud.order.api.domain.request;


import lombok.Data;

/**
*
* Created by imake on 2020年05月08日10:28:40.
*/

@Data
public class OrderDataRePayRequest extends OrderDataCreateRequest {

    private Long id;

    private String openId;

}