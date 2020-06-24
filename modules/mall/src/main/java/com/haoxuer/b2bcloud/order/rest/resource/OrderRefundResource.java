package com.haoxuer.b2bcloud.order.rest.resource;

import com.haoxuer.b2bcloud.order.api.apis.OrderRefundApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderRefundList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderRefundPage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderRefundResponse;
import com.haoxuer.b2bcloud.order.api.domain.simple.OrderItemSimple;
import com.haoxuer.b2bcloud.order.data.dao.OrderDataDao;
import com.haoxuer.b2bcloud.order.data.dao.OrderItemDao;
import com.haoxuer.b2bcloud.order.data.dao.OrderRefundDao;
import com.haoxuer.b2bcloud.order.data.dao.OrderRefundItemDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.b2bcloud.order.data.entity.OrderItem;
import com.haoxuer.b2bcloud.order.data.entity.OrderRefund;
import com.haoxuer.b2bcloud.order.data.entity.OrderRefundItem;
import com.haoxuer.b2bcloud.order.data.enums.AuditState;
import com.haoxuer.b2bcloud.order.rest.conver.OrderRefundResponseConver;
import com.haoxuer.b2bcloud.order.rest.conver.OrderRefundSimpleConver;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.bigworld.member.data.entity.TenantUser;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Component
public class OrderRefundResource implements OrderRefundApi {

    @Autowired
    private OrderRefundDao dataDao;

    @Autowired
    private OrderItemDao itemDao;

    @Autowired
    private OrderRefundItemDao refundItemDao;

    @Autowired
    private OrderDataDao orderDataDao;

    @Override
    public OrderRefundResponse create(OrderRefundCreateRequest request) {
        OrderRefundResponse result = new OrderRefundResponse();
        if (request.getItems() == null && request.getItems().size() == 0) {
            result.setCode(501);
            result.setMsg("没有退货商品");
            return result;
        }
        if (request.getOrderId() == null) {
            result.setCode(502);
            result.setMsg("无效订单id");
            return result;
        }
        if (request.getUser() == null) {
            result.setCode(505);
            result.setMsg("无效用户token");
            return result;
        }
        OrderData orderData = orderDataDao.findById(request.getOrderId());
        if (orderData == null) {
            result.setCode(503);
            result.setMsg("无效订单id");
            return result;
        }
        OrderRefund bean = new OrderRefund();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        bean.setAuditState(AuditState.init);
        bean.setOrderData(orderData);
        bean.setName(orderData.getConsignee());
        bean.setPhone(orderData.getPhone());
        bean.setNo(PayServiceImpl.getOrderNo());
        bean.setRefundDate(new Date());
        bean.setUser(TenantUser.fromId(request.getUser()));
        dataDao.save(bean);
        for (OrderItemSimple item : request.getItems()) {
            OrderItem orderItem = itemDao.findById(item.getId());
            if (orderItem == null) {
                continue;
            }
            if (orderItem.getSurplusNum() < item.getNum()) {
                result.setCode(504);
                result.setMsg(orderItem.getName() + "的退货数量大于实际数量");
                return result;
            }
            Integer left = item.getNum() - orderItem.getSurplusNum();
            orderItem.setSurplusNum(left);
            Integer returnNum = orderItem.getReturnNum();
            if (returnNum == null) {
                returnNum = 0;
            }
            returnNum = returnNum + item.getNum();
            orderItem.setReturnNum(returnNum);

            OrderRefundItem beanItem = new OrderRefundItem();
            beanItem.setNum(item.getNum());
            beanItem.setOrderItem(orderItem);
            beanItem.setRefund(bean);
            refundItemDao.save(beanItem);
        }


        result = new OrderRefundResponseConver().conver(bean);
        return result;
    }

    @Override
    public OrderRefundResponse update(OrderRefundUpdateRequest request) {
        OrderRefundResponse result = new OrderRefundResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        OrderRefund bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new OrderRefundResponseConver().conver(bean);
        return result;
    }

    private void handleData(OrderRefundCreateRequest request, OrderRefund bean) {
        bean.setPhone(request.getPhone());
        bean.setName(request.getName());
    }

    @Override
    public OrderRefundResponse delete(OrderRefundViewRequest request) {
        OrderRefundResponse result = new OrderRefundResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(), request.getId());
        return result;
    }

    @Override
    public OrderRefundResponse view(OrderRefundViewRequest request) {
        OrderRefundResponse result = new OrderRefundResponse();
        OrderRefund bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean == null) {
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result = new OrderRefundResponseConver().conver(bean);
        return result;
    }

    @Override
    public OrderRefundList list(OrderRefundListRequest request) {
        OrderRefundList result = new OrderRefundList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<OrderRefund> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new OrderRefundSimpleConver());
        return result;
    }

    @Override
    public OrderRefundPage search(OrderRefundSearchRequest request) {
        OrderRefundPage result = new OrderRefundPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<OrderRefund> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new OrderRefundSimpleConver());
        return result;
    }
}
