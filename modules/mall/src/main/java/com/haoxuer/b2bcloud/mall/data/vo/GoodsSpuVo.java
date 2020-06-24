package com.haoxuer.b2bcloud.mall.data.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class GoodsSpuVo implements Serializable {

    private String spuName;

    private String spuValue;

    private int orderNum;

}
