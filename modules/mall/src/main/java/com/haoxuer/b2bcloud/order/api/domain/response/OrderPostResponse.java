package com.haoxuer.b2bcloud.order.api.domain.response;

import com.haoxuer.bigworld.pay.api.domain.simple.WeiXinPaySimple;
import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;


@Data
public class OrderPostResponse extends ResponseObject {

    private WeiXinPaySimple pay;

    private String no;
}
