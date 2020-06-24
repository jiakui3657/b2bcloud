package com.haoxuer.b2bcloud.product.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import java.math.BigDecimal;

/**
*
* Created by imake on 2020年04月28日13:38:35.
*/

@Data
public class ProductCreateRequest extends TenantRequest {

    private String name;

    private Long label;

    private String barCode;

    private Integer catalog;

    private Long brand;

    private Long supplier;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

    private BigDecimal costPrice;

    private Integer inventory;

    private Integer warningValue;

    private String logo;

    private String unit;

    private Double weight;

    private Double volume;

    private Double netWeight;

}