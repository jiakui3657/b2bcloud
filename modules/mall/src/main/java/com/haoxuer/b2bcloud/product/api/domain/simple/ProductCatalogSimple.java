package com.haoxuer.b2bcloud.product.api.domain.simple;


import java.io.Serializable;
import lombok.Data;

/**
*
* Created by imake on 2020年05月07日19:01:34.
*/

@Data
public class ProductCatalogSimple implements Serializable {

    private Integer id;

    private String name;
}