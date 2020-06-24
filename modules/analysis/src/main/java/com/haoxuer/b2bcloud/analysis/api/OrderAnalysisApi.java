package com.haoxuer.b2bcloud.analysis.api;

import com.haoxuer.b2bcloud.analysis.request.OrderNumRequest;
import com.haoxuer.bigworld.analysis.list.LongList;

public interface OrderAnalysisApi {

    LongList num(OrderNumRequest request);

    LongList month(OrderNumRequest request);

}
