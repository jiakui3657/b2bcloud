package com.haoxuer.b2bcloud.product.api.domain.simple;


import java.io.Serializable;
import lombok.Data;

/**
*
* Created by imake on 2020年05月06日22:17:46.
*/

@Data
public class ProductLabelSimple implements Serializable {

    private Long id;

    private String name;
}