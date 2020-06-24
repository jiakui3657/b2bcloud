package com.haoxuer.b2bcloud.product.rest.resource;

import com.haoxuer.b2bcloud.product.api.apis.ProductCatalogApi;
import com.haoxuer.b2bcloud.product.api.domain.list.ProductCatalogList;
import com.haoxuer.b2bcloud.product.api.domain.page.ProductCatalogPage;
import com.haoxuer.b2bcloud.product.api.domain.request.*;
import com.haoxuer.b2bcloud.product.api.domain.response.ProductCatalogResponse;
import com.haoxuer.b2bcloud.product.data.dao.ProductCatalogDao;
import com.haoxuer.b2bcloud.product.data.entity.ProductCatalog;
import com.haoxuer.b2bcloud.product.rest.conver.ProductCatalogResponseConver;
import com.haoxuer.b2bcloud.product.rest.conver.ProductCatalogSimpleConver;
import com.haoxuer.b2bcloud.product.rest.conver.ProductCatalogTreeConver;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.haoxuer.bigworld.member.rest.conver.PageableConver;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class ProductCatalogResource implements ProductCatalogApi {

    @Autowired
    private ProductCatalogDao dataDao;

    @Override
    public ProductCatalogResponse create(ProductCatalogCreateRequest request) {
        ProductCatalogResponse result = new ProductCatalogResponse();

        ProductCatalog bean = new ProductCatalog();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        if (request.getParent() != null) {
            bean.setParent(dataDao.findById(request.getParent()));
        }
        dataDao.save(bean);
        result = new ProductCatalogResponseConver().conver(bean);
        return result;
    }

    @Override
    public ProductCatalogResponse update(ProductCatalogUpdateRequest request) {
        ProductCatalogResponse result = new ProductCatalogResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        ProductCatalog bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new ProductCatalogResponseConver().conver(bean);
        return result;
    }

    private void handleData(ProductCatalogCreateRequest request, ProductCatalog bean) {
        if (StringUtil.isNotEmpty(request.getName())) {
            bean.setName(request.getName().trim());
        }
    }

    @Override
    public ProductCatalogResponse delete(ProductCatalogDeleteRequest request) {
        ProductCatalogResponse result = new ProductCatalogResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(), request.getId());
        return result;
    }

    @Override
    public ProductCatalogList list(ProductCatalogListRequest request) {
        ProductCatalogList result = new ProductCatalogList();
        Pageable pageable = new Pageable();
        pageable.getFilters().add(Filter.eq("levelInfo", 2));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));

        List<ProductCatalog> list = dataDao.list(pageable);
        ConverResourceUtils.converList(result, list, new ProductCatalogTreeConver());
        return result;
    }

    @Override
    public ProductCatalogPage search(ProductCatalogSearchRequest request) {
        ProductCatalogPage result = new ProductCatalogPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<ProductCatalog> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new ProductCatalogSimpleConver());
        return result;
    }
}
