package com.haoxuer.b2bcloud.product.api.domain.simple;

import lombok.Data;

import java.io.Serializable;

@Data
public class LabelSimple implements Serializable {

    private Long id;

    private String name;
}
