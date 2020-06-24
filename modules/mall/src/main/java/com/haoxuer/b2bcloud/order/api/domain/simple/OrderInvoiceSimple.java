package com.haoxuer.b2bcloud.order.api.domain.simple;


import java.io.Serializable;
import lombok.Data;

/**
*
* Created by imake on 2020年05月07日11:11:37.
*/

@Data
public class OrderInvoiceSimple implements Serializable {

    private Long id;

    private String name;
}