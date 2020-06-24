package com.haoxuer.b2bcloud.order.rest.resource;

import com.haoxuer.b2bcloud.customer.data.dao.CustomerAddressDao;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerDao;
import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerAddress;
import com.haoxuer.b2bcloud.order.api.apis.OrderTallyApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderTallyList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderTallyPage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderTallyResponse;
import com.haoxuer.b2bcloud.order.api.domain.simple.OrderItemSimple;
import com.haoxuer.b2bcloud.order.data.dao.OrderItemDao;
import com.haoxuer.b2bcloud.order.data.dao.OrderTallyDao;
import com.haoxuer.b2bcloud.order.data.dao.OrderTallyItemDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderItem;
import com.haoxuer.b2bcloud.order.data.entity.OrderTally;
import com.haoxuer.b2bcloud.order.data.entity.OrderTallyItem;
import com.haoxuer.b2bcloud.order.rest.conver.OrderTallyResponseConver;
import com.haoxuer.b2bcloud.order.rest.conver.OrderTallySimpleConver;
import com.haoxuer.bigworld.member.data.entity.TenantUser;
import com.haoxuer.bigworld.member.data.service.TenantTokenService;
import com.haoxuer.bigworld.member.rest.conver.PageableConver;
import com.haoxuer.bigworld.pay.plugins.service.impl.PayServiceImpl;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Transactional
@Component
public class OrderTallyResource implements OrderTallyApi {

    @Autowired
    private OrderTallyDao dataDao;

    @Autowired
    private OrderItemDao itemDao;

    @Autowired
    private OrderTallyItemDao tallyItemDao;

    @Autowired
    private TenantTokenService tenantTokenService;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerAddressDao addressDao;


    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public OrderTallyResponse create(OrderTallyCreateRequest request) {
        OrderTallyResponse result = new OrderTallyResponse();
        if (request.getItems() == null) {
            result.setCode(501);
            result.setMsg("没有商品");
            return result;
        }
        Long mid = tenantTokenService.user(request.getTenant(), request.getUserToken());
        Customer member = customerDao.findById(mid);
        if (member == null) {
            result.setCode(1001);
            result.setMsg("无效token");
            return result;
        }
        if (request.getCustomerAddress() == null) {
            result.setCode(1003);
            result.setMsg("没有选择收货地址");
            return result;
        }

        CustomerAddress address = addressDao.findById(request.getCustomerAddress());
        if (address == null) {
            result.setCode(1004);
            result.setMsg("无效收货地址");
            return result;
        }


        OrderTally bean = new OrderTally();
        bean.setNo(PayServiceImpl.getOrderNo());
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        bean.setCustomer(member);
        bean.setAddress(address.getAddress());
        bean.setConsignee(address.getName());
        bean.setPhone(address.getPhone());
        bean.setCustomerAddress(address);
        dataDao.save(bean);

        Integer size = 0;
        for (OrderItemSimple item : request.getItems()) {
            size = size + item.getNum();
            List<OrderItem> temps = itemDao.listByUser(mid, item.getId());
            if (temps == null || temps.size() == 0) {
                result.setCode(502);
                result.setMsg("理货单中无该商品");
                return result;
            }
            Integer surplusNum = temps.stream().mapToInt(temp -> temp.getSurplusNum()).sum();


            Integer left = surplusNum - item.getNum();
            if (left < 0) {
                result.setCode(503);
                result.setMsg(item.getName() + "数量不足");
                return result;
            }
            LinkedList<OrderItem> orderItems = new LinkedList<>();
            orderItems.addAll(temps);
            Integer num = item.getNum();

            while (num > 0) {
                OrderItem orderItem = orderItems.pop();
                num = num - orderItem.getSurplusNum();
                OrderTallyItem tallyItem = new OrderTallyItem();
                if (num >= 0) {
                    tallyItem.setSize(orderItem.getSurplusNum());
                    orderItem.setSurplusNum(0);
                } else {
                    tallyItem.setSize(num);
                    orderItem.setSurplusNum(Math.abs(num));
                }
                tallyItem.setOrderItem(orderItem);
                tallyItem.setTally(bean);
                tallyItem.setTenant(bean.getTenant());
                tallyItemDao.save(tallyItem);
            }
        }

        bean.setSize(size);
        result = new OrderTallyResponseConver().conver(bean);
        return result;
    }

    @Override
    public OrderTallyResponse update(OrderTallyUpdateRequest request) {
        OrderTallyResponse result = new OrderTallyResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        OrderTally bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new OrderTallyResponseConver().conver(bean);
        return result;
    }

    private void handleData(OrderTallyCreateRequest request, OrderTally bean) {
        bean.setNo(request.getNo());
        bean.setConsignee(request.getConsignee());
        bean.setNote(request.getNote());
        bean.setAddress(request.getAddress());
        bean.setPhone(request.getPhone());
        bean.setState(request.getState());
    }

    @Override
    public OrderTallyResponse delete(OrderTallyViewRequest request) {
        OrderTallyResponse result = new OrderTallyResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(), request.getId());
        return result;
    }

    @Override
    public OrderTallyResponse view(OrderTallyViewRequest request) {
        OrderTallyResponse result = new OrderTallyResponse();
        OrderTally bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean == null) {
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result = new OrderTallyResponseConver().conver(bean);
        return result;
    }

    @Override
    public OrderTallyList list(OrderTallyListRequest request) {
        OrderTallyList result = new OrderTallyList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<OrderTally> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new OrderTallySimpleConver());
        return result;
    }

    @Override
    public OrderTallyPage search(OrderTallySearchRequest request) {
        OrderTallyPage result = new OrderTallyPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        if ("ascending".equals(request.getSortMethod())) {
            pageable.getOrders().add(Order.asc("" + request.getSortField()));
        } else if ("descending".equals(request.getSortMethod())) {
            pageable.getOrders().add(Order.desc("" + request.getSortField()));
        } else {
            pageable.getOrders().add(Order.desc("id"));
        }
        Page<OrderTally> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new OrderTallySimpleConver());
        return result;
    }
}
