package com.haoxuer.b2bcloud.product.controller.admin;


import com.haoxuer.b2bcloud.product.data.entity.ProductSpecValue;
import com.haoxuer.b2bcloud.product.data.service.ProductSpecValueService;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.utils.FilterUtils;
import com.haoxuer.b2bcloud.product.data.so.ProductSpecSo;
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
import  com.haoxuer.b2bcloud.product.data.entity.ProductSpec;
import com.haoxuer.b2bcloud.product.data.service.ProductSpecService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import com.haoxuer.discover.data.page.Filter;

import java.util.Collections;

/**
*
* Created by imake on 2020年04月15日19:22:54.
*/


@Scope("prototype")
@Controller
public class ProductSpecAction extends TenantBaseAction {

	public static final String MODEL = "model";

	public static final String REDIRECT_LIST_HTML = "redirect:/tenant/productspec/view_list.htm";

	private static final Logger log = LoggerFactory.getLogger(ProductSpecAction.class);

	@Autowired
	private ProductSpecService manager;

	@Autowired
	private TenantService tenantService;

	@Autowired
	private ProductSpecValueService valueService;

	@RequiresPermissions("productspec")
	@RequestMapping("/tenant/productspec/view_list")
	public String list(Pageable pageable,ProductSpecSo so,ModelMap model) {

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
		Page<ProductSpec> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return getView("productspec/list");
	}

	@RequiresPermissions("productspec")
	@RequestMapping("/tenant/productspec/view_config")
	public String config(Long id,ModelMap model) {
		ProductSpec spec= manager.findById(id);
		model.addAttribute(MODEL, spec);
		if (spec != null) {
			model.addAttribute("items", spec.getSpecs());
		}
		return getView("productspec/config");
	}

	@RequiresPermissions("productspec")
	@RequestMapping("/tenant/productspec/model_save_item")
	public String saveItem(ProductSpecValue bean, RedirectAttributes attributes) {

		String view = "redirect:/tenant/productspec/view_config.htm";
		try {
			attributes.addAttribute("id", bean.getSpec().getId());
			valueService.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("保存失败", e);
		}
		return view;
	}

	@RequiresPermissions("productspec")
	@RequestMapping("/tenant/productspec/model_delete_item")
	public String deleteItem(Long id, RedirectAttributes attributes) {

		String view = "redirect:/tenant/productspec/view_config.htm";
		try {
			ProductSpecValue item = valueService.findById(id);
			valueService.deleteById(id);
			attributes.addAttribute("id", item.getSpec().getId());
		} catch (Exception e) {
			log.error("删除失败", e);
		}
		return view;
	}

	@RequiresPermissions("productspec")
	@RequestMapping("/tenant/productspec/model_update_item")
	public String updateItem(ProductSpecValue bean, RedirectAttributes attributes) {

		String view = "redirect:/tenant/productspec/view_config.htm";
		try {
			valueService.update(bean);
			log.info("save object id={}", bean.getId());
			attributes.addAttribute("id", bean.getSpec().getId());
		} catch (Exception e) {
			log.error("保存失败", e);
		}
		return view;
	}


	@RequiresPermissions("productspec")
	@RequestMapping("/tenant/productspec/view_add")
	public String add(ModelMap model) {
		return  getView("productspec/add");
	}

	@RequiresPermissions("productspec")
	@RequestMapping("/tenant/productspec/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return getView("productspec/edit");
	}

	@RequiresPermissions("productspec")
	@RequestMapping("/tenant/productspec/view_view")
	public String view(Long id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return getView("productspec/view");
	}

	@RequiresPermissions("productspec")
	@RequestMapping("/tenant/productspec/model_save")
	public String save(ProductSpec bean,ModelMap model) {
	
	    String view=REDIRECT_LIST_HTML;
		try {
			bean.setTenant(tenantService.cur());
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view=getView("productspec/add");
		}
		return view;
	}

	@RequiresPermissions("productspec")
	@RequestMapping("/tenant/productspec/model_update")
	public String update(Pageable pageable, ProductSpec bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view=REDIRECT_LIST_HTML;
		try {
			manager.update(bean);
			initRedirectData(pageable, redirectAttributes);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view=getView("productspec/edit");
		}
		return view;
	}
	@RequiresPermissions("productspec")
	@RequestMapping("/tenant/productspec/model_delete")
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

	@RequiresPermissions("productspec")
	@RequestMapping("/tenant/productspec/model_deletes")
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