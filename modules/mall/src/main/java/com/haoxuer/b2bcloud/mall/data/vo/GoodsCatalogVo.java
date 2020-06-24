package com.haoxuer.b2bcloud.mall.data.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GoodsCatalogVo implements Serializable {

    private String text;

    private Integer id;

    private List<GoodsCatalogVo> nodes;
}
