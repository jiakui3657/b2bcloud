package com.haoxuer.b2bcloud.customer.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年04月28日18:51:06.
*/

@Data
public class CustomerResponse extends ResponseObject {

    private Long id;

    private String name;
}