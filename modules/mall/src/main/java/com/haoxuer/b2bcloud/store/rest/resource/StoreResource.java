package com.haoxuer.b2bcloud.store.rest.resource;

import com.haoxuer.b2bcloud.store.api.apis.StoreApi;
import com.haoxuer.b2bcloud.store.api.domain.list.StoreList;
import com.haoxuer.b2bcloud.store.api.domain.page.StorePage;
import com.haoxuer.b2bcloud.store.api.domain.request.*;
import com.haoxuer.b2bcloud.store.api.domain.response.StoreResponse;
import com.haoxuer.b2bcloud.store.data.dao.StoreDao;
import com.haoxuer.b2bcloud.store.data.entity.Store;
import com.haoxuer.b2bcloud.store.rest.conver.StoreResponseConver;
import com.haoxuer.b2bcloud.store.rest.conver.StoreSimpleConver;
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
public class StoreResource implements StoreApi {

    @Autowired
    private StoreDao dataDao;

    @Override
    public StoreResponse create(StoreCreateRequest request) {
        StoreResponse result = new StoreResponse();

        Store bean = new Store();
        bean.setName(request.getName());
        bean.setTenant(Tenant.fromId(request.getTenant()));
        dataDao.save(bean);
        result = new StoreResponseConver().conver(bean);
        return result;
    }

    @Override
    public StoreResponse update(StoreUpdateRequest request) {
        StoreResponse result = new StoreResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Store org = dataDao.findById(request.getId());
        if (org == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        if (StringUtil.isNotEmpty(request.getName())) {
            org.setName(request.getName().trim());
        }
        result = new StoreResponseConver().conver(org);
        return result;
    }

    @Override
    public StoreResponse delete(StoreDeleteRequest request) {
        StoreResponse result = new StoreResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getTenant(),request.getId());
        return result;
    }

    @Override
    public StoreResponse view(ViewRequest request) {
        StoreResponse result=new StoreResponse();
        Store bean = dataDao.findById(request.getTenant(), request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new StoreResponseConver().conver(bean);
        return result;
    }
    @Override
    public StoreList list(StoreListRequest request) {
        StoreList result = new StoreList();

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("tenant.id", request.getTenant()));
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc(" sortNum"));
        List<Store> organizations = dataDao.list(0, 100, filters, orders);
        ConverResourceUtils.converList(result, organizations, new StoreSimpleConver());
        return result;
    }

    @Override
    public StorePage search(StoreSearchRequest request) {
        StorePage result=new StorePage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));
        Page<Store> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new StoreSimpleConver());
        return result;
    }
}
