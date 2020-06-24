package com.haoxuer.b2bcloud.mall.data.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.haoxuer.b2bcloud.mall.data.dao.GoodsSkuDao;
import com.haoxuer.b2bcloud.mall.data.entity.Goods;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsSku;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsSpu;
import com.haoxuer.b2bcloud.mall.data.service.GoodsSkuService;
import com.haoxuer.b2bcloud.mall.data.vo.GoodsSpuSkuVo;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import com.haoxuer.discover.data.core.Finder;
import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by imake on 2020年01月17日14:08:58.
 */


@Scope("prototype")
@Service
@Transactional
public class GoodsSkuServiceImpl implements GoodsSkuService {

    private GoodsSkuDao dao;



    @Override
    @Transactional(readOnly = true)
    public GoodsSku findById(Long id) {
        return dao.findById(id);
    }


    @Override
    @Transactional
    public GoodsSku save(GoodsSku bean) {
        dao.save(bean);
        return bean;
    }

    @Override
    @Transactional
    public GoodsSku update(GoodsSku bean) {
        Updater<GoodsSku> updater = new Updater<GoodsSku>(bean);
        return dao.updateByUpdater(updater);
    }

    @Override
    @Transactional
    public GoodsSku deleteById(Long id) {
        GoodsSku bean = dao.findById(id);
        dao.deleteById(id);
        return bean;
    }

    @Override
    @Transactional
    public GoodsSku[] deleteByIds(Long[] ids) {
        GoodsSku[] beans = new GoodsSku[ids.length];
        for (int i = 0, len = ids.length; i < len; i++) {
            beans[i] = deleteById(ids[i]);
        }
        return beans;
    }


    @Autowired
    public void setDao(GoodsSkuDao dao) {
        this.dao = dao;
    }

    @Override
    public Page<GoodsSku> page(Pageable pageable) {
        return dao.page(pageable);
    }


    @Override
    public Page<GoodsSku> page(Pageable pageable, Object search) {
        List<Filter> filters = FilterUtils.getFilters(search);
        if (filters != null) {
            pageable.getFilters().addAll(filters);
        }
        return dao.page(pageable);
    }

    @Override
    public List<GoodsSku> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first, size, filters, orders);
    }

    @Override
    public List<GoodsSku> listSku(long goodsId,long tenantId) {

        List<Filter> filters = Lists.newArrayList();
        filters.add(Filter.eq("tenant.id", tenantId));
        filters.add(Filter.eq("goods.id", goodsId));
        List<Order> orders = Lists.newArrayList();
        List<GoodsSku> list = dao.list(0, 30, filters, orders);
        return list;
    }

    @Override
    public GoodsSku findSkuByGoodsId(long goodsId) {
        Filter f = Filter.eq("goods.id", goodsId);
        GoodsSku sku = dao.one();
        return sku;
    }

    @Override
    public void creatGoodsSpuSku(GoodsSpuSkuVo vo, Goods goods) {

        //生成spu
        String spuJson = vo.getSpuJson();
        List<Long> nl = Lists.newArrayList();
        JSONArray jsonArray = new JSONArray(spuJson);
        for (Object o : jsonArray) {
            JSONObject object = (JSONObject) o;
            Long spuName = Long.valueOf(object.getString("spuName"));
            nl.add(spuName);
        }

        //保存sku
        String skuJson = vo.getSkuJson();
        JSONArray skuJsonArray = new JSONArray(skuJson);
        for (Object o : skuJsonArray) {
            JSONArray skuTr = new JSONArray(o.toString());
            List<String> nStr = Lists.newArrayList();
            List<Long> vl = Lists.newArrayList();
            for (Object o1 : skuTr) {
                JSONObject object = (JSONObject) o1;
                String text = object.getString("text");
                Long value = Long.valueOf(object.getString("value"));
                nStr.add(text);
                vl.add(value);

            }
            //生成sku名称
            GoodsSku sku = new GoodsSku();
            String skuName = "";
            for (String text : nStr) {
                skuName += text + "/";
                sku.setSkuName(skuName);
            }
            //生成sku中的属性ID
            List<GoodsSpu> spuId = Lists.newArrayList();
            for (Long id : vl) {
                GoodsSpu spu = new GoodsSpu();
                spu.setId(id);
                spuId.add(spu);
            }
//          sku.setSkuNo();
            sku.setSpuValueId(JSON.toJSONString(vl));
            sku.setSpuNameId(JSON.toJSONString(nl));
            sku.setGoods(goods);
            this.save(sku);
        }
    }
}