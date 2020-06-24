package com.haoxuer.b2bcloud.product.data.so;

import java.io.Serializable;
import java.util.List;

import com.haoxuer.discover.data.enums.StoreState;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
* Created by imake on 2020年03月23日16:15:52.
*/
@Data
public class ProductSo implements Serializable {

    @Search(name = "name",operator = Filter.Operator.like)
    private String name;

    @Search(name = "category.id",operator = Filter.Operator.eq)
    private  Integer category;

    @Search(name = "storeState",operator = Filter.Operator.eq)
    private StoreState state;

    @Search(name = "catalog.id",operator = Filter.Operator.in)
    private List<Integer> catalogs;


}
