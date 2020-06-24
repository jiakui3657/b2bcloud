package com.haoxuer.b2bcloud.product.freemaker;

import com.google.gson.Gson;
import com.haoxuer.b2bcloud.product.api.apis.ProductCatalogApi;
import com.haoxuer.b2bcloud.product.api.domain.list.ProductCatalogList;
import com.haoxuer.b2bcloud.product.api.domain.request.ProductCatalogListRequest;
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

@Component("productCatalogJsonDirective")
public class ProductCatalogJsonDirective  implements TemplateDirectiveModel {

    @Autowired
    ProductCatalogApi api;

    @Autowired
    TenantService tenantService;

    @Override
    public void execute(Environment env, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        if (env != null) {
            Tenant tenant = tenantService.cur();

            ProductCatalogListRequest request = new ProductCatalogListRequest();
            if (tenant != null) {
                request.setTenant(tenant.getId());
            }
            ProductCatalogList list = api.list(request);
            if (list != null && list.getList() != null && list.getList().size() > 0) {
                env.getOut().append(new Gson().toJson(list.getList()));
            }else{
                env.getOut().append("[]");
            }
        }
    }
}
