package com.haoxuer.b2bcloud.product.freemaker;

import com.google.gson.Gson;
import com.haoxuer.b2bcloud.product.api.apis.ProductLabelApi;
import com.haoxuer.b2bcloud.product.api.domain.list.ProductLabelList;
import com.haoxuer.b2bcloud.product.api.domain.request.ProductLabelListRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component("productLabelJsonDirective")
public class ProductLabelJsonDirective implements TemplateDirectiveModel {

    @Autowired
    ProductLabelApi api;

    @Autowired
    TenantService tenantService;

    @Override
    public void execute(Environment env, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        if (env != null) {
            Tenant tenant = tenantService.cur();

            ProductLabelListRequest  request = new ProductLabelListRequest();
            if (tenant != null) {
                request.setTenant(tenant.getId());
            }
            ProductLabelList list = api.list(request);
            if (list != null && list.getList() != null && list.getList().size() > 0) {
                env.getOut().append(new Gson().toJson(list.getList()));
            }else{
                env.getOut().append("[]");
            }
        }
    }
}
