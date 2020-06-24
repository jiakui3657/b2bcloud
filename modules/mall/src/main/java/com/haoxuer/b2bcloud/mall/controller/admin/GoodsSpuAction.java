package com.haoxuer.b2bcloud.mall.controller.admin;


import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.utils.FilterUtils;
import com.haoxuer.b2bcloud.mall.data.so.GoodsSpuSo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import  com.haoxuer.b2bcloud.mall.data.entity.GoodsSpu;
import com.haoxuer.b2bcloud.mall.data.service.GoodsSpuService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;

/**
*
* Created by imake on 2019年12月29日13:42:02.
*/


@Scope("prototype")
@Controller
public class GoodsSpuAction {

	public static final String MODEL = "model";

	public static final String REDIRECT_LIST_HTML = "redirect:/admin/goodsspu/view_list.htm";

	private static final Logger log = LoggerFactory.getLogger(GoodsSpuAction.class);

	@Autowired
	private GoodsSpuService manager;

	@Autowired
	private TenantService tenantService;

	@RequiresPermissions("goodsspu")
	@RequestMapping("/admin/goodsspu/view_list")
	public String list(Pageable pageable,GoodsSpuSo so,ModelMap model) {

		if (pageable==null){
			pageable=new Pageable();
		}
		if (pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
		}
		Tenant tenant = tenantService.cur();
		if (tenant != null) {
		    pageable.getFilters().add(Filter.eq("tenant.id", tenant.getId()));
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<GoodsSpu> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return "/tenant/goodsspu/list";
	}

	@RequiresPermissions("goodsspu")
	@RequestMapping("/admin/goodsspu/view_add")
	public String add(ModelMap model) {
		return "/tenant/goodsspu/add";
	}

	@RequiresPermissions("goodsspu")
	@RequestMapping("/admin/goodsspu/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/tenant/goodsspu/edit";
	}

	@RequiresPermissions("goodsspu")
	@RequestMapping("/admin/goodsspu/view_view")
	public String view(Long id,ModelMap model) {

		model.addAttribute(MODEL, manager.findById(id));
		return "/tenant/goodsspu/view";
	}

	@RequiresPermissions("goodsspu")
	@RequestMapping("/admin/goodsspu/model_save")
	public String save(GoodsSpu bean,ModelMap model) {
	
	    String view=REDIRECT_LIST_HTML;
		try {
			bean.setTenant(tenantService.cur());
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/tenant/goodsspu/add";
		}
		return view;
	}

	@RequiresPermissions("goodsspu")
	@RequestMapping("/admin/goodsspu/model_update")
	public String update(Pageable pageable, GoodsSpu bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view=REDIRECT_LIST_HTML;
		try {
			manager.update(bean);
			initRedirectData(pageable, redirectAttributes);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/tenant/goodsspu/edit";
		}
		return view;
	}
	@RequiresPermissions("goodsspu")
	@RequestMapping("/admin/goodsspu/model_delete")
	public String delete(Pageable pageable, Long id, RedirectAttributes redirectAttributes) {

		String view=REDIRECT_LIST_HTML;

		try {
			initRedirectData(pageable, redirectAttributes);
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}

		return view;
	}

	@RequiresPermissions("goodsspu")
	@RequestMapping("/admin/goodsspu/model_deletes")
	public String deletes(Pageable pageable, Long[] ids,RedirectAttributes redirectAttributes) {

		String view=REDIRECT_LIST_HTML;

		try{
				initRedirectData(pageable, redirectAttributes);
				manager.deleteByIds(ids);
			} catch (DataIntegrityViolationException e) {
				log.error("批量删除失败",e);
				redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
			}
		return view;
	}
	private void initRedirectData(Pageable pageable, RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
	}
}