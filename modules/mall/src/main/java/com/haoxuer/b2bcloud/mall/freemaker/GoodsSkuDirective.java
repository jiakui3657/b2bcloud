package com.haoxuer.b2bcloud.mall.freemaker;

import com.haoxuer.b2bcloud.mall.data.entity.GoodsSku;
import com.haoxuer.b2bcloud.mall.data.entity.SpuName;
import com.haoxuer.b2bcloud.mall.data.service.GoodsSkuService;
import com.haoxuer.b2bcloud.mall.data.service.SpuNameService;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import com.haoxuer.discover.common.freemarker.ListDirective;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component("goodsSkuDirective")
public class GoodsSkuDirective extends ListDirective<GoodsSku> {

    @Autowired
    private TenantService tenantService;

    @Autowired
    private GoodsSkuService goodsSkuService;

    @Override
    public List<GoodsSku> list() {
        List<Filter> filters = new ArrayList<>();
        Tenant tenant = tenantService.cur();
        if (tenant != null) {
            filters.add(Filter.eq("tenant.id", tenant.getId()));
        }
        List<Order> orders = new ArrayList<>();
        orders.add(Order.desc("addDate"));
        List<GoodsSku>  list = goodsSkuService.list(0, getInt("size", 30), filters, orders);
        return list;
    }
}
