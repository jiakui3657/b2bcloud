package com.haoxuer.b2bcloud.product.rest.resource;

import com.haoxuer.b2bcloud.product.api.apis.ProductLabelApi;
import com.haoxuer.b2bcloud.product.api.domain.list.ProductLabelList;
import com.haoxuer.b2bcloud.product.api.domain.page.ProductLabelPage;
import com.haoxuer.b2bcloud.product.api.domain.request.*;
import com.haoxuer.b2bcloud.product.api.domain.response.ProductLabelResponse;
import com.haoxuer.b2bcloud.product.data.dao.ProductLabelDao;
import com.haoxuer.b2bcloud.product.data.entity.ProductLabel;
import com.haoxuer.b2bcloud.product.rest.conver.ProductLabelResponseConver;
import com.haoxuer.b2bcloud.product.rest.conver.ProductLabelSimpleConver;
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
public class ProductLabelResource implements ProductLabelApi {

    @Autowired
    private ProductLabelDao dataDao;

    @Override
    public ProductLabelResponse create(ProductLabelCreateRequest request) {
        ProductLabelResponse result = new ProductLabelResponse();
        if (StringUtil.isEmpty(request.getName())) {
            result.setCode(501);
            result.setMsg("无效标签名");
            return result;
        }
        ProductLabel bean = new ProductLabel();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new ProductLabelResponseConver().conver(bean);
        return result;
    }

    @Override
    public ProductLabelResponse update(ProductLabelUpdateRequest request) {
        ProductLabelResponse result = new ProductLabelResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        ProductLabel bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new ProductLabelResponseConver().conver(bean);
        return result;
    }

    private void handleData(ProductLabelCreateRequest request, ProductLabel bean) {
        if (StringUtil.isNotEmpty(request.getName())) {
            bean.setName(request.getName().trim());
        }
    }

    @Override
    public ProductLabelResponse delete(ProductLabelDeleteRequest request) {
        ProductLabelResponse result = new ProductLabelResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(), request.getId());
        return result;
    }

    @Override
    public ProductLabelResponse view(ViewRequest request) {
        ProductLabelResponse result = new ProductLabelResponse();
        ProductLabel bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean == null) {
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result = new ProductLabelResponseConver().conver(bean);
        return result;
    }

    @Override
    public ProductLabelList list(ProductLabelListRequest request) {
        ProductLabelList result = new ProductLabelList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<ProductLabel> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new ProductLabelSimpleConver());
        return result;
    }

    @Override
    public ProductLabelPage search(ProductLabelSearchRequest request) {
        ProductLabelPage result = new ProductLabelPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        Page<ProductLabel> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new ProductLabelSimpleConver());
        return result;
    }
}
