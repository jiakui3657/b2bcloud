package com.haoxuer.b2bcloud.product.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年05月07日19:01:34.
*/

@Data
public class ProductCatalogResponse extends ResponseObject {

    private Integer id;

    private String name;
}