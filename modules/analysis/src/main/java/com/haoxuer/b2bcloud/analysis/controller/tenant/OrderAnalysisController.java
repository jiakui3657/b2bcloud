package com.haoxuer.b2bcloud.analysis.controller.tenant;

import com.haoxuer.b2bcloud.analysis.api.OrderAnalysisApi;
import com.haoxuer.b2bcloud.analysis.request.OrderNumRequest;
import com.haoxuer.bigworld.analysis.list.LongList;
import com.haoxuer.bigworld.member.controller.tenant.BaseTenantRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tenantRest/order")
@RestController
public class OrderAnalysisController extends BaseTenantRestController {

    @RequestMapping("num")
    public LongList num(OrderNumRequest request) {
        initTenant(request);
        return api.num(request);
    }

    @RequestMapping("month")
    public LongList month(OrderNumRequest request) {
        initTenant(request);
        return api.month(request);
    }

    @Autowired
    private OrderAnalysisApi api;
}
