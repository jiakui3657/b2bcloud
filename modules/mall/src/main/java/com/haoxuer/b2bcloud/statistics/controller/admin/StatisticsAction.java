package com.haoxuer.b2bcloud.statistics.controller.admin;

import com.haoxuer.b2bcloud.order.data.entity.OrderExchange;
import com.haoxuer.b2bcloud.order.data.so.OrderExchangeSo;
import com.haoxuer.bigworld.tenant.controller.admin.TenantBaseAction;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Scope("prototype")
@Controller
public class StatisticsAction extends TenantBaseAction {

    @RequiresPermissions("statistics_home")
    @RequestMapping("/tenant/statistics/home")
    public String list(Pageable pageable, OrderExchangeSo so, ModelMap model) {
        return getView("statistics/home");
    }

    @RequiresPermissions("statistics_customer")
    @RequestMapping("/tenant/statistics/customer")
    public String customer(Pageable pageable, OrderExchangeSo so, ModelMap model) {
        return getView("statistics/customer");
    }


    @RequiresPermissions("statistics_kpi")
    @RequestMapping("/tenant/statistics/kpi")
    public String kpi(Pageable pageable, OrderExchangeSo so, ModelMap model) {
        return getView("statistics/kpi");
    }

    @RequiresPermissions("statistics_goods")
    @RequestMapping("/tenant/statistics/goods")
    public String goods(Pageable pageable, OrderExchangeSo so, ModelMap model) {
        return getView("statistics/goods");
    }

    @RequiresPermissions("statistics_area")
    @RequestMapping("/tenant/statistics/area")
    public String area(Pageable pageable, OrderExchangeSo so, ModelMap model) {
        return getView("statistics/area");
    }
}
