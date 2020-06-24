package com.haoxuer.b2bcloud.customer.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年04月30日15:32:18.
*/

@Data
public class CustomerAddressResponse extends ResponseObject {

    private Long id;

    private String name;
}