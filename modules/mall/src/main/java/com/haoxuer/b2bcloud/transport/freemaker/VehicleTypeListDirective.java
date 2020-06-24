package com.haoxuer.b2bcloud.transport.freemaker;

import com.haoxuer.b2bcloud.transport.data.entity.VehicleType;
import com.haoxuer.b2bcloud.transport.data.service.VehicleTypeService;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import com.haoxuer.discover.common.freemarker.ListDirective;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("vehicleTypeListDirective")
public class VehicleTypeListDirective extends ListDirective<VehicleType> {

    @Autowired
    private TenantService tenantService;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Override
    public List<VehicleType> list() {
        List<Filter> filters = new ArrayList<>();
        Tenant tenant = tenantService.cur();
        if (tenant != null) {
            filters.add(Filter.eq("tenant.id", tenant.getId()));
        }
        //  filters.add(Filter.eq("levelInfo",2));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.desc("id"));
        return vehicleTypeService.list(0, getInt("size", 30), filters, orders);
    }
}
