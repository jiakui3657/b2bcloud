package com.haoxuer.b2bcloud.order.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年05月07日11:11:37.
*/

@Data
public class OrderInvoiceResponse extends ResponseObject {

    private Long id;

    private String name;
}