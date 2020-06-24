package com.haoxuer.b2bcloud.product.rest.resource;

import com.haoxuer.b2bcloud.product.api.apis.ProductApi;
import com.haoxuer.b2bcloud.product.api.domain.list.ProductList;
import com.haoxuer.b2bcloud.product.api.domain.page.ProductPage;
import com.haoxuer.b2bcloud.product.api.domain.request.*;
import com.haoxuer.b2bcloud.product.api.domain.response.ProductResponse;
import com.haoxuer.b2bcloud.product.data.dao.ProductCatalogDao;
import com.haoxuer.b2bcloud.product.data.dao.ProductDao;
import com.haoxuer.b2bcloud.product.data.dao.ProductLabelDao;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.b2bcloud.product.data.enums.ProductState;
import com.haoxuer.b2bcloud.product.rest.conver.ProductResponseConver;
import com.haoxuer.b2bcloud.product.rest.conver.ProductSimpleConver;
import com.haoxuer.b2bcloud.purchase.data.dao.SupplierDao;
import com.haoxuer.bigworld.brand.data.dao.BrandDao;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.bigworld.member.rest.conver.PageableConver;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.enums.StoreState;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class ProductResource implements ProductApi {

    @Autowired
    private ProductDao dataDao;

    @Autowired
    private ProductLabelDao labelDao;

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private ProductCatalogDao catalogDao;

    @Autowired
    private SupplierDao supplierDao;

    @Override
    public ProductResponse create(ProductCreateRequest request) {
        ProductResponse result = new ProductResponse();

        Product bean = new Product();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new ProductResponseConver().conver(bean);
        return result;
    }

    @Override
    public ProductResponse update(ProductUpdateRequest request) {
        ProductResponse result = new ProductResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Product org = dataDao.findById(request.getId());
        if (org == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, org);
        result = new ProductResponseConver().conver(org);
        return result;
    }

    private void handleData(ProductCreateRequest request, Product bean) {
        if (StringUtil.isNotEmpty(request.getName())) {
            bean.setName(request.getName().trim());
        }
        if (request.getLabel() != null) {
            bean.setLabel(labelDao.findById(request.getLabel()));
        }
        if (request.getBrand() != null) {
            bean.setBrand(brandDao.findById(request.getBrand()));
        }
        if (request.getCatalog() != null) {
            bean.setCatalog(catalogDao.findById(request.getCatalog()));
        }
        if (request.getSupplier() != null) {
            bean.setSupplier(supplierDao.findById(request.getSupplier()));
        }
        bean.setBarCode(request.getBarCode());
        bean.setLogo(request.getLogo());
        bean.setSalePrice(request.getSalePrice());
        bean.setMarketPrice(request.getMarketPrice());
        bean.setCostPrice(request.getCostPrice());
        bean.setUnit(request.getUnit());
        bean.setVolume(request.getVolume());
        bean.setWeight(request.getWeight());
        bean.setNetWeight(request.getNetWeight());
    }

    @Override
    public ProductResponse delete(ProductDeleteRequest request) {
        ProductResponse result = new ProductResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public ProductList list(ProductListRequest request) {
        ProductList result = new ProductList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<Product> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new ProductSimpleConver());
        return result;
    }

    @Override
    public ProductPage search(ProductSearchRequest request) {
        ProductPage result = new ProductPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<Product> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new ProductSimpleConver());
        return result;
    }

    @Override
    public ProductResponse view(ViewRequest request) {
        ProductResponse result=new ProductResponse();
        Product bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new ProductResponseConver().conver(bean);
        return result;
    }

    @Override
    public ProductPage page(ProductPageRequest request) {
        ProductPage result = new ProductPage();

        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().add(Filter.eq("storeState", StoreState.normal));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getOrders().add(Order.asc("sortNum"));
        Page<Product> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new ProductSimpleConver());
        return result;
    }

    @Override
    public ProductResponse offLine(ViewRequest request) {
        ProductResponse result=new ProductResponse();
        Product bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        bean.setState(ProductState.lowerShelf);
        return result;
    }

    @Override
    public ProductResponse onLine(ViewRequest request) {
        ProductResponse result=new ProductResponse();
        Product bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        bean.setState(ProductState.onSale);
        return result;
    }
}
