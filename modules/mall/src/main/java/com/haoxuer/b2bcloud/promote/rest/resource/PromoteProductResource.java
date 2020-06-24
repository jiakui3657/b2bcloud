package com.haoxuer.b2bcloud.promote.rest.resource;

import com.haoxuer.b2bcloud.product.data.dao.ProductDao;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.b2bcloud.promote.api.apis.PromoteProductApi;
import com.haoxuer.b2bcloud.promote.api.domain.list.PromoteProductList;
import com.haoxuer.b2bcloud.promote.api.domain.page.PromoteProductPage;
import com.haoxuer.b2bcloud.promote.api.domain.request.*;
import com.haoxuer.b2bcloud.promote.api.domain.response.PromoteProductResponse;
import com.haoxuer.b2bcloud.promote.data.dao.PromoteDao;
import com.haoxuer.b2bcloud.promote.data.dao.PromoteProductDao;
import com.haoxuer.b2bcloud.promote.data.entity.Promote;
import com.haoxuer.b2bcloud.promote.data.entity.PromoteProduct;
import com.haoxuer.b2bcloud.promote.rest.conver.PromoteProductResponseConver;
import com.haoxuer.b2bcloud.promote.rest.conver.PromoteProductSimpleConver;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class PromoteProductResource implements PromoteProductApi {

    @Autowired
    private PromoteProductDao dataDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private PromoteDao promoteDao;

    @Override
    public PromoteProductResponse create(PromoteProductCreateRequest request) {
        PromoteProductResponse result = new PromoteProductResponse();
        if (request.getProduct() == null) {
            result.setCode(501);
            result.setMsg("产品id不能为空");
            return result;
        }
        if (request.getPromote() == null) {
            result.setCode(501);
            result.setMsg("活动id不能为空");
            return result;
        }
        Long num = dataDao.countQuery(Filter.eq("product.id", request.getProduct()),
                Filter.eq("promote.id", request.getPromote()));
        if (num > 0) {
            result.setCode(502);
            result.setMsg("该活动已经添加该商品");
            return result;
        }
        PromoteProduct bean = new PromoteProduct();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new PromoteProductResponseConver().conver(bean);
        return result;
    }

    @Override
    public PromoteProductResponse update(PromoteProductUpdateRequest request) {
        PromoteProductResponse result = new PromoteProductResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        PromoteProduct bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        bean.setPrice(request.getPrice());
        result = new PromoteProductResponseConver().conver(bean);
        return result;
    }

    private void handleData(PromoteProductCreateRequest request, PromoteProduct bean) {
        bean.setProduct(productDao.findById(request.getProduct()));
        bean.setPromote(promoteDao.findById(request.getPromote()));
    }

    @Override
    public PromoteProductResponse delete(PromoteProductViewRequest request) {
        PromoteProductResponse result = new PromoteProductResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(), request.getId());
        return result;
    }

    @Override
    public PromoteProductResponse view(PromoteProductViewRequest request) {
        PromoteProductResponse result = new PromoteProductResponse();
        PromoteProduct bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean == null) {
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result = new PromoteProductResponseConver().conver(bean);
        return result;
    }

    @Override
    public PromoteProductList list(PromoteProductListRequest request) {
        PromoteProductList result = new PromoteProductList();
        Promote promote = promoteDao.findById(request.getPromote());
        if (promote != null) {
            result.setScale(promote.getScale());
            result.setMini(promote.getMini());
        }
        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.add(Filter.eq("promote.id", request.getPromote()));
        filters.add(Filter.gt("price", new BigDecimal(0)));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        List<PromoteProduct> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new PromoteProductSimpleConver());
        return result;
    }

    @Override
    public PromoteProductPage search(PromoteProductSearchRequest request) {
        PromoteProductPage result = new PromoteProductPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<PromoteProduct> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new PromoteProductSimpleConver());
        return result;
    }
}
