package com.haoxuer.b2bcloud.finance.rest.resource;

import com.haoxuer.b2bcloud.finance.api.apis.InvoiceApi;
import com.haoxuer.b2bcloud.finance.api.domain.list.InvoiceList;
import com.haoxuer.b2bcloud.finance.api.domain.page.InvoicePage;
import com.haoxuer.b2bcloud.finance.api.domain.request.*;
import com.haoxuer.b2bcloud.finance.api.domain.response.InvoiceResponse;
import com.haoxuer.b2bcloud.finance.data.dao.InvoiceDao;
import com.haoxuer.b2bcloud.finance.data.entity.Invoice;
import com.haoxuer.b2bcloud.finance.rest.conver.InvoiceResponseConver;
import com.haoxuer.b2bcloud.finance.rest.conver.InvoiceSimpleConver;
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
public class InvoiceResource implements InvoiceApi {

    @Autowired
    private InvoiceDao dataDao;

    @Override
    public InvoiceResponse create(InvoiceCreateRequest request) {
        InvoiceResponse result = new InvoiceResponse();

        Invoice bean = new Invoice();
        bean.setTenant(Tenant.fromId(request.getTenant()));
        handleData(request, bean);
        dataDao.save(bean);
        result = new InvoiceResponseConver().conver(bean);
        return result;
    }

    @Override
    public InvoiceResponse update(InvoiceUpdateRequest request) {
        InvoiceResponse result = new InvoiceResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Invoice bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new InvoiceResponseConver().conver(bean);
        return result;
    }

    private void handleData(InvoiceCreateRequest request, Invoice bean) {
        bean.setAddress(request.getAddress());
        bean.setPhone(request.getPhone());
        bean.setName(request.getName());
        bean.setBankNo(request.getBankNo());
        bean.setTaxNo(request.getTaxNo());
        bean.setBankName(request.getBankName());
    }

    @Override
    public InvoiceResponse delete(InvoiceViewRequest request) {
        InvoiceResponse result = new InvoiceResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(),request.getId());
        return result;
    }

    @Override
    public InvoiceResponse view(InvoiceViewRequest request) {
        InvoiceResponse result=new InvoiceResponse();
        Invoice bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new InvoiceResponseConver().conver(bean);
        return result;
    }
    @Override
    public InvoiceList list(InvoiceListRequest request) {
        InvoiceList result = new InvoiceList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<Invoice> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new InvoiceSimpleConver());
        return result;
    }

    @Override
    public InvoicePage search(InvoiceSearchRequest request) {
        InvoicePage result=new InvoicePage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        pageable.getOrders().add(Order.desc("id"));
        Page<Invoice> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new InvoiceSimpleConver());
        return result;
    }
}
