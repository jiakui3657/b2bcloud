package com.haoxuer.b2bcloud.analysis.mapper;

import com.haoxuer.b2bcloud.analysis.request.OrderNumRequest;
import com.haoxuer.bigworld.analysis.simple.LongName;

import java.util.List;

public interface OrderMapper {

    List<LongName> num(OrderNumRequest request);

    List<LongName> month(OrderNumRequest request);

}
