package com.haoxuer.b2bcloud.customer.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年05月09日15:47:39.
*/

@Data
public class CustomerTagResponse extends ResponseObject {

    private Long id;

     private Long num;

     private String name;

}