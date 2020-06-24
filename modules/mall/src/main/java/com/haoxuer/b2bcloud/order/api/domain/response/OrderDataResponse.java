package com.haoxuer.b2bcloud.order.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年05月08日10:28:40.
*/

@Data
public class OrderDataResponse extends ResponseObject {

    private Long id;

    private String name;
}