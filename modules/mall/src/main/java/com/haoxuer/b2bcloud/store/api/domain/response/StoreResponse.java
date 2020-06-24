package com.haoxuer.b2bcloud.store.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年05月02日15:43:56.
*/

@Data
public class StoreResponse extends ResponseObject {

    private Long id;

    private String name;
}