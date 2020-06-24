package com.haoxuer.b2bcloud.mall.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TreeSimple implements Serializable {

    private Integer id;

    private String name;

    private List<TreeSimple> children;
}
