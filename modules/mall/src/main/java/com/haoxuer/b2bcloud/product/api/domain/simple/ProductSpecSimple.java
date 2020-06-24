package com.haoxuer.b2bcloud.product.api.domain.simple;

import com.haoxuer.b2bcloud.product.data.entity.ProductSpec;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductSpecSimple implements Serializable {

    private String label;

    private Long id;

    private List<ProductSpecValueSimple> items=new ArrayList<>();
}
