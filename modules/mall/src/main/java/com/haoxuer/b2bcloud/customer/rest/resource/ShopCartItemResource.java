package com.haoxuer.b2bcloud.customer.rest.resource;

import com.haoxuer.b2bcloud.customer.api.apis.ShopCartItemApi;
import com.haoxuer.b2bcloud.customer.api.domain.list.ShopCartItemList;
import com.haoxuer.b2bcloud.customer.api.domain.page.ShopCartItemPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.ShopCartItemResponse;
import com.haoxuer.b2bcloud.customer.data.dao.ShopCartDao;
import com.haoxuer.b2bcloud.customer.data.dao.ShopCartItemDao;
import com.haoxuer.b2bcloud.customer.data.entity.ShopCart;
import com.haoxuer.b2bcloud.customer.data.entity.ShopCartItem;
import com.haoxuer.b2bcloud.customer.rest.conver.ShopCartItemResponseConver;
import com.haoxuer.b2bcloud.customer.rest.conver.ShopCartItemSimpleConver;
import com.haoxuer.b2bcloud.order.data.dao.OrderTradeItemDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderTradeItem;
import com.haoxuer.b2bcloud.order.rest.conver.OrderTradeItemSimpleConver;
import com.haoxuer.b2bcloud.product.data.dao.ProductDao;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.bigworld.member.data.entity.TenantUser;
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
public class ShopCartItemResource implements ShopCartItemApi {

    @Autowired
    private ShopCartItemDao dataDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ShopCartDao cartDao;

    @Autowired
    private OrderTradeItemDao tradeItemDao;

    @Override
    public ShopCartItemResponse create(ShopCartItemCreateRequest request) {
        ShopCartItemResponse result = new ShopCartItemResponse();
        if (request.getUser() == null) {
            result.setCode(501);
            result.setMsg("无效用户token");
            return result;
        }
        if (request.getProduct() == null) {
            result.setCode(502);
            result.setMsg("产品id为空");
            return result;
        }
        Product product = productDao.findById(request.getProduct());
        if (product == null) {
            result.setCode(503);
            result.setMsg("无效产品");
            return result;
        }
        if (product.getSalePrice() == null) {
            result.setCode(504);
            result.setMsg("产品无价格");
            return result;
        }

        if (request.getSize() == null) {
            request.setSize(1);
        }

        ShopCart cart = cartDao.findByUser(request.getUser(), request.getTenant());
        ShopCartItem item = dataDao.findByCart(cart.getId(), request.getProduct());
        if (item == null) {
            item = new ShopCartItem();
            item.setCart(cart);
            item.setProduct(product);
            item.setSize(0);
            item.setUser(TenantUser.fromId(request.getUser()));
            item.setTenant(Tenant.fromId(request.getTenant()));
            dataDao.save(item);
        }
        item.setPrice(product.getSalePrice());
        item.setSize(request.getSize());
        BigDecimal total = product.getSalePrice().multiply(new BigDecimal(request.getSize()));
        item.setTotal(total);


        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("trade.customer.id", request.getUser()));
        filters.add(Filter.eq("product.id", request.getProduct()));
        filters.add(Filter.gt("surplusNum", 0));

        List<OrderTradeItem> tradeItems = tradeItemDao.list(0, 100, filters, null);
        result = new ShopCartItemResponseConver().conver(item);
        if (tradeItems != null && tradeItems.size() > 0) {
            result.setItems(ConverResourceUtils.converCollect(tradeItems, new OrderTradeItemSimpleConver()));
        }

        return result;
    }

    @Override
    public ShopCartItemResponse update(ShopCartItemUpdateRequest request) {
        ShopCartItemResponse result = new ShopCartItemResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        ShopCartItem bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new ShopCartItemResponseConver().conver(bean);
        return result;
    }

    private void handleData(ShopCartItemCreateRequest request, ShopCartItem bean) {
        bean.setTrade(request.getTrade());
        bean.setSize(request.getSize());
    }

    @Override
    public ShopCartItemResponse delete(ShopCartItemViewRequest request) {
        ShopCartItemResponse result = new ShopCartItemResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(), request.getId());
        return result;
    }

    @Override
    public ShopCartItemResponse view(ShopCartItemViewRequest request) {
        ShopCartItemResponse result = new ShopCartItemResponse();
        ShopCartItem bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean == null) {
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result = new ShopCartItemResponseConver().conver(bean);
        return result;
    }

    @Override
    public ShopCartItemList list(ShopCartItemListRequest request) {
        ShopCartItemList result = new ShopCartItemList();
        if (request.getUser() == null) {
            result.setCode(501);
            result.setMsg("无效用户token");
            return result;
        }
        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.add(Filter.eq("user.id", request.getUser()));

        List<Order> orders = new ArrayList<>();
        orders.add(Order.desc("id"));

        List<ShopCartItem> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new ShopCartItemSimpleConver());
        return result;
    }

    @Override
    public ShopCartItemPage search(ShopCartItemSearchRequest request) {
        ShopCartItemPage result = new ShopCartItemPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<ShopCartItem> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new ShopCartItemSimpleConver());
        return result;
    }
}
