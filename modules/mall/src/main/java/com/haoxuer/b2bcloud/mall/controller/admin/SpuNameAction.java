package com.haoxuer.b2bcloud.mall.controller.admin;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.haoxuer.b2bcloud.mall.data.entity.SpuName;
import com.haoxuer.b2bcloud.mall.data.entity.SpuValue;
import com.haoxuer.b2bcloud.mall.data.service.SpuNameService;
import com.haoxuer.b2bcloud.mall.data.service.SpuValueService;
import com.haoxuer.b2bcloud.mall.data.so.SpuNameSo;
import com.haoxuer.b2bcloud.mall.data.vo.GoodsSpuVo;
import com.haoxuer.b2bcloud.mall.data.vo.SpuValueVo;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by imake on 2019年12月31日15:41:42.
 */


@Scope("prototype")
@Controller
public class SpuNameAction {

    public static final String MODEL = "model";

    public static final String REDIRECT_LIST_HTML = "redirect:/admin/spuname/view_list.htm";

    private static final Logger log = LoggerFactory.getLogger(SpuNameAction.class);

    @Autowired
    private SpuNameService manager;

    @Autowired
    private SpuValueService spuValueService;

    @Autowired
    private TenantService tenantService;

    @RequiresPermissions("spuname")
    @RequestMapping("/admin/spuname/view_list")
    public String list(Pageable pageable, SpuNameSo so, ModelMap model) {

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
        Page<SpuName> pagination = manager.page(pageable);
        model.addAttribute("list", pagination.getContent());
        model.addAttribute("page", pagination);
        model.addAttribute("so", so);
        return "/tenant/spuname/list";
    }

    @RequiresPermissions("spuname")
    @RequestMapping("/admin/spuname/view_add")
    public String add(ModelMap model) {
        return "/tenant/spuname/add";
    }

    @RequiresPermissions("spuname")
    @RequestMapping("/admin/spuname/view_edit")
    public String edit(Pageable pageable, Long id, ModelMap model) {
        model.addAttribute(MODEL, manager.findById(id));
        model.addAttribute("page", pageable);
        List<Filter> filters = new ArrayList<>();
        Tenant tenant = tenantService.cur();
        if (tenant != null) {
            filters.add(Filter.eq("tenant.id", tenant.getId()));
            filters.add(Filter.eq("spuName.id", id));
        }
        List<Order> orders = new ArrayList<>();
        orders.add(Order.desc("id"));
        List<SpuValue> list = spuValueService.findlist(0, null, filters, orders);
        model.addAttribute("spuValueList", list);
        return "/tenant/spuname/edit";
    }

    @RequiresPermissions("spuname")
    @RequestMapping("/admin/spuname/view_view")
    public String view(Long id, ModelMap model) {
        model.addAttribute(MODEL, manager.findById(id));
        return "/tenant/spuname/view";
    }

    @RequiresPermissions("spuname")
    @RequestMapping("/admin/spuname/model_save")
    public String save(SpuName bean, GoodsSpuVo vo, ModelMap model) {

        String view = REDIRECT_LIST_HTML;
        try {
            bean.setTenant(tenantService.cur());
            manager.save(bean);
            String spuValueStr = vo.getSpuValue();
            List<Map<String, String>> spuValue = new ObjectMapper().readValue(spuValueStr, new TypeReference<List<Map<String, String>>>() {});
            for (Map<String, String> map : spuValue) {
                String spuVal = map.get("spuVal");
                SpuValue value = new SpuValue();
                value.setSpuValue(spuVal);
                value.setSpuName(bean);
                value.setTenant(tenantService.cur());
                spuValueService.save(value);
            }
            log.info("save object id={}", bean.getId());
        } catch (Exception e) {
            log.error("保存失败", e);
            model.addAttribute("erro", e.getMessage());
            view = "/tenant/spuname/add";
        }
        return view;
    }

    @RequiresPermissions("spuname")
    @RequestMapping("/admin/spuname/model_update")
    public String update(Pageable pageable, SpuName bean, GoodsSpuVo vo, RedirectAttributes redirectAttributes, ModelMap model) {

        String view = REDIRECT_LIST_HTML;
        try {
            manager.update(bean);

            String spuValueStr = vo.getSpuValue();
            List<Map<String, String>> spuValue = new ObjectMapper().readValue(spuValueStr, new TypeReference<List<Map<String, String>>>() {});
            for (Map<String, String> map : spuValue) {
                String spuVal = map.get("spuVal");
                long spuValId = Long.valueOf(map.get("spuValId"));
                SpuValue value = new SpuValue();
                value.setTenant(tenantService.cur());
                value.setSpuValue(spuVal);
                value.setSpuName(bean);
                if (spuValId>0){
                    //如果没有添加规格值就修改
                    value.setId(spuValId);
                    spuValueService.update(value);
                }else{
                    //如果添加有规格值就保存
                    spuValueService.save(value);
                }
            }
            initRedirectData(pageable, redirectAttributes);
        } catch (Exception e) {
            log.error("更新失败", e);
            model.addAttribute("erro", e.getMessage());
            model.addAttribute(MODEL, bean);
            model.addAttribute("page", pageable);
            view = "/tenant/spuname/edit";
        }
        return view;
    }

    @RequiresPermissions("spuname")
    @RequestMapping("/admin/spuname/model_delete")
    public String delete(Pageable pageable, Long id, RedirectAttributes redirectAttributes) {

        String view = REDIRECT_LIST_HTML;

        try {
            initRedirectData(pageable, redirectAttributes);
            manager.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            log.error("删除失败", e);
            redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
        }

        return view;
    }

    @RequiresPermissions("spuname")
    @RequestMapping("/admin/spuname/model_deletes")
    public String deletes(Pageable pageable, Long[] ids, RedirectAttributes redirectAttributes) {

        String view = REDIRECT_LIST_HTML;

        try {
            initRedirectData(pageable, redirectAttributes);
            manager.deleteByIds(ids);
        } catch (DataIntegrityViolationException e) {
            log.error("批量删除失败", e);
            redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
        }
        return view;
    }


    @RequiresPermissions("spuname")
    @RequestMapping("/admin/spuname/model_find")
    @ResponseBody
    public  List<SpuValueVo>  findJson(SpuNameSo so, ModelMap model) {
        List<SpuValueVo> result= Lists.newArrayList();
        List<Filter> filters =  Lists.newArrayList();
        Tenant tenant = tenantService.cur();
        if (tenant != null) {
            filters.add(Filter.eq("tenant.id", tenant.getId()));
            filters.add(Filter.eq("spuName.id", so.getId()));
        }
        List<Order> orders = new ArrayList<>();
        orders.add(Order.desc("id"));
        List<SpuValue> list = spuValueService.findlist(0, null, filters, orders);
        if (list!=null&&list.size()>0){
            result=   list.stream().map(item->{
                SpuValueVo vo=new SpuValueVo();
                vo.setId(item.getId());
                vo.setSpuValue(item.getSpuValue());
                vo.setStatus(item.getStatus());
                return vo;
            }).collect(Collectors.toList());
        }
        return result;
    }

    private void initRedirectData(Pageable pageable, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("pageNumber", pageable.getPageNumber());
    }
}