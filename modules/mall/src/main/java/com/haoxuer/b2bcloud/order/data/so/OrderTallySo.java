package com.haoxuer.b2bcloud.order.data.so;

import java.io.Serializable;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
* Created by imake on 2020年06月04日16:56:41.
*/
@Data
public class OrderTallySo implements Serializable {

    //收货人
     @Search(name = "consignee",operator = Filter.Operator.like)
     private String consignee;

    //联系电话
     @Search(name = "phone",operator = Filter.Operator.like)
     private String phone;



}
