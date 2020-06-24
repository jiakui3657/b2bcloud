package com.haoxuer.b2bcloud.product.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年05月06日22:17:46.
*/

@Data
public class ProductLabelResponse extends ResponseObject {

    private Long id;

    private String name;
}