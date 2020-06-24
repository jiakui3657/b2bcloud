package com.haoxuer.b2bcloud.mall.data.so;

import java.io.Serializable;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
* Created by imake on 2019年12月29日13:46:48.
*/
@Data
public class GoodsSo implements Serializable {

    @Search(name = "name",operator = Filter.Operator.like)
    private String name;

    @Search(name = "brand.name",operator = Filter.Operator.like)
    private String brandName;

    @Search(name = "code",operator = Filter.Operator.like)
    private String code;

}
