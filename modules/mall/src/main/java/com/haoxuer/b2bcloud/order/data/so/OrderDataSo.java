package com.haoxuer.b2bcloud.order.data.so;

import java.io.Serializable;
import java.util.Date;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
* Created by imake on 2020年05月08日10:28:40.
*/
@Data
public class OrderDataSo implements Serializable {

    @Search(name = "consignee", operator = Filter.Operator.like)
    private String name;

    @Search(name = "addDate", operator = Filter.Operator.ge, prefix = "begx")
    private Date beginDate;


    @Search(name = "addDate", operator = Filter.Operator.le, prefix = "endx")
    private Date endDate;


}
