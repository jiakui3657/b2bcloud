package com.haoxuer.b2bcloud.mall.freemaker;

import com.haoxuer.b2bcloud.mall.data.entity.GoodsBrand;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsCatalog;
import com.haoxuer.b2bcloud.mall.data.service.GoodsBrandService;
import com.haoxuer.b2bcloud.mall.data.service.GoodsCatalogService;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import com.haoxuer.discover.common.freemarker.ListDirective;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component("goodsBrandDirective")
public class GoodsBrandDirective extends ListDirective<GoodsBrand>{


    @Autowired
    private TenantService tenantService;

    @Autowired
    private GoodsBrandService goodsBrandService;



    @Override
    public List<GoodsBrand> list() {
        List<Filter> filters = new ArrayList<>();
        Tenant tenant = tenantService.cur();
        if (tenant != null) {
            filters.add(Filter.eq("tenant.id", tenant.getId()));
        }
//        filters.add(Filter.eq("levelInfo",2));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.desc("id"));
        return goodsBrandService.list(0, getInt("size", 30), filters, orders);
    }
}
