package com.haoxuer.b2bcloud.promote.controller.admin;


import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.utils.FilterUtils;
import com.haoxuer.b2bcloud.promote.data.so.PromoteSo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.haoxuer.bigworld.tenant.controller.admin.TenantBaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import  com.haoxuer.b2bcloud.promote.data.entity.Promote;
import com.haoxuer.b2bcloud.promote.data.service.PromoteService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import com.haoxuer.discover.data.page.Filter;

/**
*
* Created by imake on 2020年05月11日14:18:16.
*/


@Scope("prototype")
@Controller
public class PromoteAction extends TenantBaseAction {

	public static final String MODEL = "model";

	public static final String REDIRECT_LIST_HTML = "redirect:/tenant/promote/view_list.htm";

	private static final Logger log = LoggerFactory.getLogger(PromoteAction.class);

	@Autowired
	private PromoteService manager;

	@Autowired
	private TenantService tenantService;

	@RequiresPermissions("promote")
	@RequestMapping("/tenant/promote/view_list")
	public String list(Pageable pageable,PromoteSo so,ModelMap model) {

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
		Page<Promote> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return getView("promote/list");
	}

	@RequiresPermissions("promote")
	@RequestMapping("/tenant/promote/view_add")
	public String add(ModelMap model) {
		return  getView("promote/add");
	}

	@RequiresPermissions("promote")
	@RequestMapping("/tenant/promote/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		Tenant tenant=tenantService.cur();
		model.addAttribute(MODEL, manager.findById(tenant.getId(),id));
		model.addAttribute("page", pageable);
		return getView("promote/edit");
	}

	@RequiresPermissions("promote")
	@RequestMapping("/tenant/promote/view_view")
	public String view(Long id,ModelMap model) {
		Tenant tenant=tenantService.cur();
		model.addAttribute(MODEL, manager.findById(tenant.getId(),id));
		return getView("promote/view");
	}

	@RequiresPermissions("promote")
	@RequestMapping("/tenant/promote/model_save")
	public String save(Promote bean,ModelMap model) {
	
	    String view=REDIRECT_LIST_HTML;
		try {
			bean.setTenant(tenantService.cur());
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view=getView("promote/add");
		}
		return view;
	}

	@RequiresPermissions("promote")
	@RequestMapping("/tenant/promote/model_update")
	public String update(Pageable pageable, Promote bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view=REDIRECT_LIST_HTML;
		try {
			manager.update(bean);
			initRedirectData(pageable, redirectAttributes);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view=getView("promote/edit");
		}
		return view;
	}
	@RequiresPermissions("promote")
	@RequestMapping("/tenant/promote/model_delete")
	public String delete(Pageable pageable, Long id, RedirectAttributes redirectAttributes) {

		String view=REDIRECT_LIST_HTML;

		try {
			initRedirectData(pageable, redirectAttributes);
			Tenant tenant=tenantService.cur();
			manager.deleteById(tenant.getId(),id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}

		return view;
	}

	@RequiresPermissions("promote")
	@RequestMapping("/tenant/promote/model_deletes")
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