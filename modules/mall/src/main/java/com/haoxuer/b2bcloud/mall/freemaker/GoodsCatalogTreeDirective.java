package com.haoxuer.b2bcloud.mall.freemaker;

import com.google.gson.Gson;
import com.haoxuer.b2bcloud.mall.data.conver.GoodsCatalogVoConver;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsCatalog;
import com.haoxuer.b2bcloud.mall.data.service.GoodsCatalogService;
import com.haoxuer.b2bcloud.mall.data.vo.GoodsCatalogVo;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import com.haoxuer.discover.common.freemarker.ListDirective;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component("goodsCatalogTreeDirective")
public class GoodsCatalogTreeDirective implements TemplateDirectiveModel {

    @Autowired
    private TenantService tenantService;

    @Autowired
    private GoodsCatalogService catalogService;


    @Override
    public void execute(Environment env, Map map, TemplateModel[] templateModels, TemplateDirectiveBody body) throws TemplateException, IOException {
        if (env != null) {
            List<Filter> filters = new ArrayList<>();
            Tenant tenant = tenantService.cur();
            if (tenant != null) {
                filters.add(Filter.eq("tenant.id", tenant.getId()));
            }
            filters.add(Filter.eq("levelInfo",2));
            List<Order> orders = new ArrayList<>();
            orders.add(Order.desc("id"));
            List<GoodsCatalog> list =  catalogService.list(0, 30, filters, orders);
            if (list!=null&&list.size()>0){
                List<GoodsCatalogVo> vs= ConverResourceUtils.converCollect(list,new GoodsCatalogVoConver());
                env.getOut().append(new Gson().toJson(vs));
            }
        }
    }
}
