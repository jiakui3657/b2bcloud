package com.haoxuer.b2bcloud.order.rest.resource;

import com.haoxuer.b2bcloud.order.api.apis.OrderInvoiceApi;
import com.haoxuer.b2bcloud.order.api.domain.list.OrderInvoiceList;
import com.haoxuer.b2bcloud.order.api.domain.page.OrderInvoicePage;
import com.haoxuer.b2bcloud.order.api.domain.request.*;
import com.haoxuer.b2bcloud.order.api.domain.response.OrderInvoiceResponse;
import com.haoxuer.b2bcloud.order.data.dao.OrderInvoiceDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderInvoice;
import com.haoxuer.b2bcloud.order.rest.conver.OrderInvoiceResponseConver;
import com.haoxuer.b2bcloud.order.rest.conver.OrderInvoiceSimpleConver;
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
public class OrderInvoiceResource implements OrderInvoiceApi {

    @Autowired
    private OrderInvoiceDao dataDao;

    @Override
    public OrderInvoiceResponse create(OrderInvoiceCreateRequest request) {
        OrderInvoiceResponse result = new OrderInvoiceResponse();

        OrderInvoice bean = new OrderInvoice();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new OrderInvoiceResponseConver().conver(bean);
        return result;
    }

    @Override
    public OrderInvoiceResponse update(OrderInvoiceUpdateRequest request) {
        OrderInvoiceResponse result = new OrderInvoiceResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        OrderInvoice bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new OrderInvoiceResponseConver().conver(bean);
        return result;
    }

    private void handleData(OrderInvoiceCreateRequest request, OrderInvoice bean) {
        if (StringUtil.isNotEmpty(request.getName())) {
        }
    }

    @Override
    public OrderInvoiceResponse delete(OrderInvoiceDeleteRequest request) {
        OrderInvoiceResponse result = new OrderInvoiceResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(),request.getId());
        return result;
    }

    @Override
    public OrderInvoiceResponse view(ViewRequest request) {
        OrderInvoiceResponse result=new OrderInvoiceResponse();
        OrderInvoice bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new OrderInvoiceResponseConver().conver(bean);
        return result;
    }
    @Override
    public OrderInvoiceList list(OrderInvoiceListRequest request) {
        OrderInvoiceList result = new OrderInvoiceList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<OrderInvoice> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new OrderInvoiceSimpleConver());
        return result;
    }

    @Override
    public OrderInvoicePage search(OrderInvoiceSearchRequest request) {
        OrderInvoicePage result=new OrderInvoicePage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<OrderInvoice> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new OrderInvoiceSimpleConver());
        return result;
    }
}
