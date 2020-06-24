package com.haoxuer.b2bcloud.product.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

import java.math.BigDecimal;

/**
*
* Created by imake on 2020年04月28日13:38:35.
*/

@Data
public class ProductResponse extends ResponseObject {

    private Long id;

    private String name;

    private Long label;

    private String  barCode ;

    private Integer catalog;

    private Long brand;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

    private BigDecimal costPrice;

    private Integer inventory;

    private Integer warningValue;

    private String logo;

    private String unit;

    private Long supplier;

    private Double weight;

    private Double volume;

    private Double netWeight;
}