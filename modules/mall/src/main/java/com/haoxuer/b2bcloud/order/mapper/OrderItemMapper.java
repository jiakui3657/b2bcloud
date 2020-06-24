package com.haoxuer.b2bcloud.order.mapper;

import com.haoxuer.b2bcloud.order.api.domain.simple.OrderTempSimple;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;

import java.util.List;

public interface OrderItemMapper {

    List<OrderTempSimple> list(TenantPageRequest request);
}
