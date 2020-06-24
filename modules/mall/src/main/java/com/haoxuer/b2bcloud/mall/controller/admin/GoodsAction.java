package com.haoxuer.b2bcloud.mall.controller.admin;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.haoxuer.b2bcloud.mall.data.entity.Goods;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsSku;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsSpu;
import com.haoxuer.b2bcloud.mall.data.service.GoodsService;
import com.haoxuer.b2bcloud.mall.data.service.GoodsSkuService;
import com.haoxuer.b2bcloud.mall.data.so.GoodsSo;
import com.haoxuer.b2bcloud.mall.data.vo.GoodsSpuSkuVo;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by imake on 2019年12月29日13:46:48.
 */


@Scope("prototype")
@Controller
public class GoodsAction {

    public static final String MODEL = "model";

    public static final String REDIRECT_LIST_HTML = "redirect:/admin/goods/view_list.htm";

    private static final Logger log = LoggerFactory.getLogger(GoodsAction.class);

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsSkuService skuService;

    @Autowired
    private TenantService tenantService;

    @RequiresPermissions("goods")
    @RequestMapping("/admin/goods/view_list")
    public String list(Pageable pageable, GoodsSo so, ModelMap model) {

        if (pageable == null) {
            pageable = new Pageable();
        }
        if (pageable.getOrders().isEmpty()) {
            pageable.getOrders().add(Order.desc("id"));
        }
        Tenant tenant = tenantService.cur();
        if (tenant != null) {
            pageable.getFilters().add(Filter.eq("tenant.id", tenant.getId()));
        }
        pageable.getFilters().addAll(FilterUtils.getFilters(so));
        Page<Goods> pagination = goodsService.page(pageable);
        model.addAttribute("list", pagination.getContent());
        model.addAttribute("page", pagination);
        model.addAttribute("so", so);
        return "/tenant/goods/list";
    }

    @RequiresPermissions("goods")
    @RequestMapping("/admin/goods/view_add")
    public String add(ModelMap model) {
        return "/tenant/goods/add";
    }

    @RequiresPermissions("goods")
    @RequestMapping("/admin/goods/view_edit")
    public String edit(Pageable pageable, Long id, ModelMap model) {

//        for (GoodsSku sku :list ){
//            sku.setGoods(null);
//            sku.setTenant(null);
//        }
        //model.addAttribute("spuJson", goodsService.findById(id));
//        List<GoodsSku> skulists = skuService.listSku(id,tenantService.cur().getId());
//        model.addAttribute("skulist", skulists);
        model.addAttribute(MODEL, goodsService.findById(id));
        model.addAttribute("page", pageable);
        return "/tenant/goods/edit";
    }

    @RequiresPermissions("goods")
    @RequestMapping("/admin/goods/view_view")
    public String view(Long id, ModelMap model) {
        model.addAttribute(MODEL, goodsService.findById(id));
        return "/tenant/goods/view";
    }

    @RequiresPermissions("goods")
    @RequestMapping("/admin/goods/model_save")
    public String save(Goods bean, GoodsSpuSkuVo vo, ModelMap model) {

        String view = REDIRECT_LIST_HTML;
        try {

            //保存基础数据
            bean.setTenant(tenantService.cur());
            goodsService.save(bean);
            vo.setGoodsId(bean.getId());
            skuService.creatGoodsSpuSku(vo,bean);
            log.info("save object id={}", bean.getId());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("保存失败", e);
            model.addAttribute("erro", e.getMessage());
            view = "/tenant/goods/add";
        }
        return view;
    }

    @RequiresPermissions("goods")
    @RequestMapping("/admin/goods/model_update")
    public String update(Pageable pageable, Goods goods, GoodsSpuSkuVo vo, RedirectAttributes redirectAttributes, ModelMap model) {

        String view = REDIRECT_LIST_HTML;
        try {

            goods.setTenant(tenantService.cur());
			goodsService.update(goods);


            GoodsSku skuBean =  skuService.findSkuByGoodsId(goods.getId());


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
                if(skuBean!=null){
                    sku.setSpuValueId(JSON.toJSONString(vl));
                    sku.setSpuNameId(JSON.toJSONString(nl));
                    sku.setGoods(goods);
                    skuService.update(sku);
                }else{
                    sku.setSpuValueId(JSON.toJSONString(vl));
                    sku.setSpuNameId(JSON.toJSONString(nl));
                    sku.setGoods(goods);
                    skuService.save(sku);
                }

            }

			log.info("save object id={}", goods.getId());
            initRedirectData(pageable, redirectAttributes);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("更新失败", e);
            model.addAttribute("erro", e.getMessage());
            model.addAttribute(MODEL, goods);
            model.addAttribute("page", pageable);
            view = "/tenant/goods/edit";
        }
        return view;
    }

    @RequiresPermissions("goods")
    @RequestMapping("/admin/goods/model_delete")
    public String delete(Pageable pageable, Long id, RedirectAttributes redirectAttributes) {

        String view = REDIRECT_LIST_HTML;

        try {
            initRedirectData(pageable, redirectAttributes);
            goodsService.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            log.error("删除失败", e);
            redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
        }

        return view;
    }

    @RequiresPermissions("goods")
    @RequestMapping("/admin/goods/model_deletes")
    public String deletes(Pageable pageable, Long[] ids, RedirectAttributes redirectAttributes) {

        String view = REDIRECT_LIST_HTML;

        try {
            initRedirectData(pageable, redirectAttributes);
            goodsService.deleteByIds(ids);
        } catch (DataIntegrityViolationException e) {
            log.error("批量删除失败", e);
            redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
        }
        return view;
    }

    private void initRedirectData(Pageable pageable, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("pageNumber", pageable.getPageNumber());
    }
}