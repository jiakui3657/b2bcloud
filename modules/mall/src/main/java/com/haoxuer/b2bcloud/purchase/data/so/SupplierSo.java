package com.haoxuer.b2bcloud.purchase.data.so;

import java.io.Serializable;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
* Created by imake on 2020年05月12日19:55:07.
*/
@Data
public class SupplierSo implements Serializable {

    //供货商名称
     @Search(name = "shop",operator = Filter.Operator.like)
     private String shop;

    //联系人
     @Search(name = "name",operator = Filter.Operator.like)
     private String name;

    //手机号码
     @Search(name = "phone",operator = Filter.Operator.like)
     private String phone;



}
