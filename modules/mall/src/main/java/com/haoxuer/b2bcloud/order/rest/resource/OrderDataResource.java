package com.haoxuer.b2bcloud.order.rest.resource;

import com.haoxuer.b2bcloud.customer.data.dao.CustomerAddressDao;
import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerAddress;
import com.haoxuer.b2bcloud.order.api.apis.OrderDataApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderDataList;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderPage;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderTempList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderDataPage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderDataResponse;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderPostResponse;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderResponse;
import com.haoxuer.b2bcloud.order.api.domain.simple.OrderItemSimple;
import com.haoxuer.b2bcloud.order.api.domain.simple.OrderTempSimple;
import com.haoxuer.b2bcloud.order.data.dao.OrderDataDao;
import com.haoxuer.b2bcloud.order.data.dao.OrderItemDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.b2bcloud.order.data.entity.OrderItem;
import com.haoxuer.b2bcloud.order.data.entity.OrderTrade;
import com.haoxuer.b2bcloud.order.mapper.OrderItemMapper;
import com.haoxuer.b2bcloud.order.rest.conver.OrderDataResponseConver;
import com.haoxuer.b2bcloud.order.rest.conver.OrderDataSimpleConver;
import com.haoxuer.b2bcloud.order.rest.conver.OrderResponseConver;
import com.haoxuer.b2bcloud.order.rest.conver.OrderSimpleConver;
import com.haoxuer.b2bcloud.product.data.dao.ProductDao;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.bigworld.member.data.dao.TenantUserDao;
import com.haoxuer.bigworld.member.data.entity.TenantUser;
import com.haoxuer.bigworld.member.data.service.TenantTokenService;
import com.haoxuer.bigworld.pay.api.domain.simple.WeiXinPaySimple;
import com.haoxuer.bigworld.pay.data.dao.PaymentDao;
import com.haoxuer.bigworld.pay.data.dao.SnDao;
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
public class OrderDataResource implements OrderDataApi {


    @Autowired
    private TenantTokenService tenantTokenService;

    @Autowired
    private OrderDataDao dataDao;

    @Autowired
    private TenantUserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private PayService payService;

    @Autowired
    private SnDao snDao;

    @Autowired
    private OrderItemDao itemDao;

    @Autowired
    private CustomerAddressDao addressDao;

    @Autowired(required = false)
    private OrderItemMapper itemMapper;

    @Override
    public OrderDataResponse create(OrderDataCreateRequest request) {
        OrderDataResponse result = new OrderDataResponse();

        OrderData bean = new OrderData();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new OrderDataResponseConver().conver(bean);
        return result;
    }

    @Override
    public OrderDataResponse update(OrderDataUpdateRequest request) {
        OrderDataResponse result = new OrderDataResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        OrderData bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new OrderDataResponseConver().conver(bean);
        return result;
    }

    private void handleData(OrderDataCreateRequest request, OrderData bean) {
        if (StringUtil.isNotEmpty(request.getName())) {
        }
    }

    @Override
    public OrderDataResponse delete(OrderDataDeleteRequest request) {
        OrderDataResponse result = new OrderDataResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(), request.getId());
        return result;
    }

    @Override
    public OrderResponse view(ViewRequest request) {
        OrderResponse result = new OrderResponse();
        OrderData bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result = new OrderResponseConver().conver(bean);
        return result;
    }

    @Override
    public OrderDataList list(OrderDataListRequest request) {
        OrderDataList result = new OrderDataList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<OrderData> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new OrderDataSimpleConver());
        return result;
    }

    @Override
    public OrderDataPage search(OrderDataSearchRequest request) {
        OrderDataPage result = new OrderDataPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        if (request.getUser() != null) {
            pageable.getFilters().add(Filter.eq("user.id", request.getUser()));
        }
        pageable.getOrders().add(Order.desc("id"));
        Page<OrderData> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new OrderDataSimpleConver());
        return result;
    }


    @Override
    public OrderPostResponse order(OrderRequest request) {
        OrderPostResponse result = new OrderPostResponse();
        Long mid = tenantTokenService.user(request.getTenant(), request.getUserToken());
        TenantUser member = userDao.findById(mid);
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

        List<OrderItem> orderItems = new ArrayList<>();
        Integer size = 0;
        BigDecimal money = new BigDecimal(0);
        for (OrderItemSimple item : items) {
            Product product = productDao.findById(item.getId());
            if (product == null) {
                continue;
            }
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setPrice(product.getSalePrice());
            orderItem.setUnit(product.getUnit());
            orderItem.setSize(item.getNum());
            orderItem.setName(product.getName());
            orderItem.setName(product.getName());
            orderItem.setLogo(product.getLogo());
            orderItems.add(orderItem);
            size = size + orderItem.getSize();
            if (product.getSalePrice() != null) {
                BigDecimal total = product.getSalePrice().multiply(new BigDecimal(item.getNum()));
                money = money.add(total);
            }
        }
        OrderData orderInfo = new OrderData();
        orderInfo.setNo(PayServiceImpl.getOrderNo());
        orderInfo.setUser(member);
        orderInfo.setAmount(money);
        orderInfo.setProductCount(size);
        orderInfo.setPayState(PayState.wait);
        orderInfo.setNote(request.getNote());
        dataDao.save(orderInfo);
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrderData(orderInfo);
            itemDao.save(orderItem);
        }
        if (request.getAddress() != null) {
            CustomerAddress address = addressDao.findById(request.getAddress());
            if (address != null) {
                orderInfo.setConsignee(address.getName());
                orderInfo.setPhone(address.getPhone());
                orderInfo.setAddress(address.getAddress());
            }

        }
        if (orderInfo.getAddress() == null) {
            CustomerAddress address = addressDao.one(
                    Filter.eq("tenant.id", request.getTenant()),
                    Filter.eq("customer.id", mid));

            if (address != null) {
                orderInfo.setConsignee(address.getName());
                orderInfo.setPhone(address.getPhone());
                orderInfo.setAddress(address.getAddress());
            }
        }


        PayInfo info = new PayInfo();
        info.setOpenid(request.getOpenId());
        info.setMoney(money);
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
        payment.setUser(PayUser.fromId(mid));
        payment.setTenant(Tenant.fromId(request.getTenant()));
        if (request.getHandle() != null && request.getHandle().length() > 3) {
            payment.setHandle(request.getHandle());
        } else {
            payment.setHandle("commonHandle");
        }
        payment.setSn(payBack.getNo());
        payment.setNo(payBack.getOrderNo());
        payment.setAmount(money);
        paymentDao.save(payment);


        return result;
    }

    @Override
    public OrderPostResponse orderData(OrderRequest request) {
        OrderPostResponse result = new OrderPostResponse();
        Long mid = tenantTokenService.user(request.getTenant(), request.getUserToken());
        TenantUser member = userDao.findById(mid);
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

        List<OrderItem> orderItems = new ArrayList<>();
        Integer size = 0;
        BigDecimal money = new BigDecimal(0);
        for (OrderItemSimple item : items) {
            Product product = productDao.findById(item.getId());
            if (product == null) {
                continue;
            }
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setPrice(product.getSalePrice());
            orderItem.setUnit(product.getUnit());
            orderItem.setSize(item.getNum());
            orderItem.setName(product.getName());
            orderItem.setUseNum(0);
            orderItem.setSurplusNum(item.getNum());
            orderItem.setReturnNum(0);
            orderItem.setLogo(product.getLogo());
            orderItems.add(orderItem);
            size = size + orderItem.getSize();
            if (product.getSalePrice() != null) {
                BigDecimal total = product.getSalePrice().multiply(new BigDecimal(item.getNum()));
                money = money.add(total);
            }
        }
        OrderData orderInfo = new OrderData();
        orderInfo.setNo(PayServiceImpl.getOrderNo());
        orderInfo.setUser(member);
        orderInfo.setAmount(money);
        orderInfo.setProductCount(size);
        orderInfo.setPayState(PayState.wait);
        orderInfo.setNote(request.getNote());
        orderInfo.setTenant(Tenant.fromId(request.getTenant()));
        dataDao.save(orderInfo);
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrderData(orderInfo);
            itemDao.save(orderItem);
        }
        if (request.getAddress() != null) {
            CustomerAddress address = addressDao.findById(request.getAddress());
            if (address != null) {
                orderInfo.setConsignee(address.getName());
                orderInfo.setPhone(address.getPhone());
                orderInfo.setAddress(address.getAddress());
            }

        }
        if (orderInfo.getAddress() == null) {
            CustomerAddress address = addressDao.one(
                    Filter.eq("tenant.id", request.getTenant()),
                    Filter.eq("customer.id", mid));

            if (address != null) {
                orderInfo.setConsignee(address.getName());
                orderInfo.setPhone(address.getPhone());
                orderInfo.setAddress(address.getAddress());
            }
        }


        PayInfo info = new PayInfo();
        info.setOpenid(request.getOpenId());
        info.setMoney(money);
        info.setPayType("wxapp");
        info.setBody("付款到商家");
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
        payment.setUser(PayUser.fromId(mid));
        payment.setTenant(Tenant.fromId(request.getTenant()));
        if (request.getHandle() != null && request.getHandle().length() > 3) {
            payment.setHandle(request.getHandle());
        } else {
            payment.setHandle("orderPayHandler");
        }
        payment.setSn(payBack.getNo());
        payment.setNo(payBack.getOrderNo());
        payment.setAmount(money);
        paymentDao.save(payment);


        return result;
    }

    @Override
    public OrderPostResponse rePay(OrderDataRePayRequest request) {
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
        OrderData orderData = dataDao.findById(request.getId());

        PayInfo info = new PayInfo();
        info.setOpenid(request.getOpenId());
        info.setMoney(orderData.getAmount());
        info.setPayType("wxapp");
        info.setBody("付款到商家");
        info.setTenant(request.getTenant());
        PayBack payBack = payService.pay(info);

        payBack.setPayType("wxapp");
        WeiXinPaySimple simple = payService.handle(payBack);
        result.setPay(simple);
        result.setNo(payBack.getNo());

        Payment payment = new Payment();
        payment.setBussId(orderData.getId());
        payment.setStatus(Payment.Status.wait);
        payment.setPayState(PayState.wait);
        payment.setUser(PayUser.fromId(mid));
        payment.setTenant(Tenant.fromId(request.getTenant()));
        payment.setHandle("orderPayHandler");
        payment.setSn(payBack.getNo());
        payment.setNo(payBack.getOrderNo());
        payment.setAmount(orderData.getAmount());
        paymentDao.save(payment);
        return result;
    }

    @Override
    public OrderPage page(TenantPageRequest request) {
        OrderPage result = new OrderPage();
        Long mid = tenantTokenService.user(request.getTenant(), request.getUserToken());
        Pageable pageable = new PageableConver().conver(request);
        pageable.getOrders().add(Order.desc("id"));
        pageable.getFilters().add(Filter.eq("user.id", mid));
        pageable.getFilters().add(Filter.eq("payState", PayState.success));
        Page<OrderData> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new OrderSimpleConver());
        return result;
    }

    @Override
    public OrderTempList temps(TenantPageRequest request) {
        OrderTempList result = new OrderTempList();
        List<OrderTempSimple> simples = itemMapper.list(request);
        if (simples != null) {
            result.setList(simples);
        }
        return result;
    }
}
