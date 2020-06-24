package com.haoxuer.b2bcloud.order.rest.resource;

import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerAddress;
import com.haoxuer.b2bcloud.order.api.apis.OrderTradeApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderTradeList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderTradePage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderPostResponse;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderTradeResponse;
import com.haoxuer.b2bcloud.order.api.domain.simple.OrderItemSimple;
import com.haoxuer.b2bcloud.order.data.dao.OrderTradeDao;
import com.haoxuer.b2bcloud.order.data.dao.OrderTradeItemDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.b2bcloud.order.data.entity.OrderItem;
import com.haoxuer.b2bcloud.order.data.entity.OrderTrade;
import com.haoxuer.b2bcloud.order.data.entity.OrderTradeItem;
import com.haoxuer.b2bcloud.order.rest.conver.OrderTradeResponseConver;
import com.haoxuer.b2bcloud.order.rest.conver.OrderTradeSimpleConver;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.b2bcloud.promote.data.dao.PromoteProductDao;
import com.haoxuer.b2bcloud.promote.data.entity.Promote;
import com.haoxuer.b2bcloud.promote.data.entity.PromoteProduct;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.bigworld.member.data.dao.TenantUserDao;
import com.haoxuer.bigworld.member.data.entity.TenantUser;
import com.haoxuer.bigworld.member.data.service.TenantTokenService;
import com.haoxuer.bigworld.pay.api.domain.simple.WeiXinPaySimple;
import com.haoxuer.bigworld.pay.data.dao.PaymentDao;
import com.haoxuer.bigworld.pay.data.entity.PayUser;
import com.haoxuer.bigworld.pay.data.entity.Payment;
import com.haoxuer.bigworld.pay.data.enums.PayState;
import com.haoxuer.bigworld.pay.plugins.domain.PayBack;
import com.haoxuer.bigworld.pay.plugins.domain.PayInfo;
import com.haoxuer.bigworld.pay.plugins.service.PayService;
import com.haoxuer.bigworld.pay.plugins.service.impl.PayServiceImpl;
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
public class OrderTradeResource implements OrderTradeApi {

    @Autowired
    private OrderTradeDao dataDao;


    @Autowired
    private TenantTokenService tenantTokenService;

    @Autowired
    private TenantUserDao userDao;

    @Autowired
    private PromoteProductDao productDao;

    @Autowired
    private PayService payService;

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private OrderTradeItemDao itemDao;


    @Override
    public OrderTradeResponse create(OrderTradeCreateRequest request) {
        OrderTradeResponse result = new OrderTradeResponse();

        OrderTrade bean = new OrderTrade();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new OrderTradeResponseConver().conver(bean);
        return result;
    }

    @Override
    public OrderTradeResponse update(OrderTradeUpdateRequest request) {
        OrderTradeResponse result = new OrderTradeResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        OrderTrade bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new OrderTradeResponseConver().conver(bean);
        return result;
    }

    private void handleData(OrderTradeCreateRequest request, OrderTrade bean) {
        bean.setNo(request.getNo());
    }

    @Override
    public OrderTradeResponse delete(OrderTradeViewRequest request) {
        OrderTradeResponse result = new OrderTradeResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(), request.getId());
        return result;
    }

    @Override
    public OrderTradeResponse view(OrderTradeViewRequest request) {
        OrderTradeResponse result = new OrderTradeResponse();
        OrderTrade bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean == null) {
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result = new OrderTradeResponseConver().conver(bean);
        return result;
    }

    @Override
    public OrderTradeList list(OrderTradeListRequest request) {
        OrderTradeList result = new OrderTradeList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<OrderTrade> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new OrderTradeSimpleConver());
        return result;
    }

    @Override
    public OrderTradePage search(OrderTradeSearchRequest request) {
        OrderTradePage result = new OrderTradePage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        if (request.getUser() != null) {
            pageable.getFilters().add(Filter.eq("customer.id", request.getUser()));
        }
        Page<OrderTrade> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new OrderTradeSimpleConver());
        return result;
    }

    @Override
    public OrderPostResponse order(OrderRequest request) {
        OrderPostResponse result = new OrderPostResponse();
        TenantUser member = userDao.findById(request.getUser());
        if (member == null) {
            result.setCode(1001);
            result.setMsg("无效token");
            return result;
        }

        List<OrderItemSimple> items = request.getItems();
        if (items == null || items.isEmpty()) {
            result.setCode(-1);
            result.setMsg("订单中无商品");
            return result;
        }

        List<OrderTradeItem> orderItems = new ArrayList<>();
        Integer size = 0;
        BigDecimal money = new BigDecimal(0);
        for (OrderItemSimple item : items) {
            PromoteProduct product = productDao.findById(item.getId());
            if (product == null) {
                continue;
            }
            OrderTradeItem orderItem = new OrderTradeItem();
            if (product.getProduct() != null) {
                Product temp = product.getProduct();
                orderItem.setName(temp.getName());
                orderItem.setLogo(temp.getLogo());
                orderItem.setProduct(temp);
            }
            orderItem.setPrice(product.getPrice());
            orderItem.setSize(item.getNum());
            orderItem.setUseNum(0);
            orderItem.setSurplusNum(item.getNum());
            orderItems.add(orderItem);
            size = size + orderItem.getSize();
            if (product.getPrice() != null) {
                BigDecimal total = product.getPrice().multiply(new BigDecimal(item.getNum()));
                money = money.add(total);
            }
        }


        OrderTrade orderInfo = new OrderTrade();
        orderInfo.setNo(PayServiceImpl.getOrderNo());
        orderInfo.setCustomer(Customer.fromId(request.getUser()));
        orderInfo.setMoney(money);
        orderInfo.setProductCount(size);
        orderInfo.setPayState(PayState.wait);
        orderInfo.setNote(request.getNote());
        orderInfo.setTenant(Tenant.fromId(request.getTenant()));
        OrderItemSimple tempItem = items.get(0);
        PromoteProduct temp = null;
        if (tempItem.getId() != null) {
            temp = productDao.findById(tempItem.getId());
            if (temp != null) {
                orderInfo.setPromote(temp.getPromote());
            }
        }
        if (temp == null) {
            result.setCode(508);
            result.setMsg("无效活动id");
            return result;
        }
        Promote promote = temp.getPromote();
        if (promote == null) {
            result.setCode(509);
            result.setMsg("无效活动id");
            return result;
        }
        if (promote.getScale() == null) {
            result.setCode(510);
            result.setMsg("该活动没启用");
            return result;
        }
        BigDecimal perScale = promote.getScale().divide(new BigDecimal(100));
        BigDecimal payMoney = money.multiply(perScale);
        orderInfo.setPayMoney(payMoney);
        dataDao.save(orderInfo);
        for (OrderTradeItem orderItem : orderItems) {
            orderItem.setTenant(orderInfo.getTenant());
            orderItem.setTrade(orderInfo);
            itemDao.save(orderItem);
        }


        PayInfo info = new PayInfo();
        info.setOpenid(request.getOpenId());
        info.setMoney(payMoney);
        info.setPayType("wxapp");
        info.setBody("付款到商家");
        info.setSubAppId(request.getSubAppId());
        info.setSubMchId(request.getSubMchId());
        info.setTenant(request.getTenant());
        PayBack payBack = payService.pay(info);
        payBack.setPayType("wxapp");
        payBack.setSubAppId(request.getSubAppId());
        WeiXinPaySimple simple = payService.handle(payBack);
        result.setPay(simple);
        result.setNo(payBack.getNo());

        Payment payment = new Payment();
        payment.setBussId(orderInfo.getId());
        payment.setStatus(Payment.Status.wait);
        payment.setPayState(PayState.wait);
        payment.setUser(PayUser.fromId(request.getUser()));
        payment.setTenant(Tenant.fromId(request.getTenant()));
        if (request.getHandle() != null && request.getHandle().length() > 3) {
            payment.setHandle(request.getHandle());
        } else {
            payment.setHandle("orderTradePayHandler");
        }
        payment.setSn(payBack.getNo());
        payment.setNo(payBack.getOrderNo());
        payment.setAmount(payMoney);
        paymentDao.save(payment);

        return result;
    }

    @Override
    public OrderPostResponse rePay(OrderTradeRePayRequest request) {
        OrderPostResponse result = new OrderPostResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效订单id");
            return result;
        }
        Long mid = tenantTokenService.user(request.getTenant(), request.getUserToken());
        TenantUser member = userDao.findById(mid);
        if (member == null) {
            result.setCode(1001);
            result.setMsg("无效token");
            return result;
        }
        OrderTrade trade = dataDao.findById(request.getId());

        PayInfo info = new PayInfo();
        info.setOpenid(request.getOpenId());
        info.setMoney(trade.getPayMoney());
        info.setPayType("wxapp");
        info.setBody("付款到商家");
        info.setTenant(request.getTenant());
        PayBack payBack = payService.pay(info);

        payBack.setPayType("wxapp");
        WeiXinPaySimple simple = payService.handle(payBack);
        result.setPay(simple);
        result.setNo(payBack.getNo());

        Payment payment = new Payment();
        payment.setBussId(trade.getId());
        payment.setStatus(Payment.Status.wait);
        payment.setPayState(PayState.wait);
        payment.setUser(PayUser.fromId(mid));
        payment.setTenant(Tenant.fromId(request.getTenant()));
        payment.setHandle("orderTradePayHandler");
        payment.setSn(payBack.getNo());
        payment.setNo(payBack.getOrderNo());
        payment.setAmount(trade.getPayMoney());
        paymentDao.save(payment);
        return result;
    }
}
