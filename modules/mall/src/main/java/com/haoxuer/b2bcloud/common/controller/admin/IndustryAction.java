package com.haoxuer.b2bcloud.common.controller.admin;


import com.haoxuer.discover.data.page.Filter;
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
import  com.haoxuer.b2bcloud.common.data.entity.Industry;
import com.haoxuer.b2bcloud.common.data.service.IndustryService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import com.haoxuer.bigworld.tenant.controller.admin.TenantBaseAction;


/**
* Created by imake on 2020年05月07日14:03:56.
*/

@Scope("prototype")
@Controller
public class IndustryAction extends TenantBaseAction {

	public static final String MODEL = "model";

	public static final String REDIRECT_LIST_HTML = "redirect:/tenant/industry/view_list.htm";

	private static final Logger log = LoggerFactory.getLogger(IndustryAction.class);

	@Autowired
	private IndustryService manager;

	@Autowired
	private TenantService tenantService;

	@RequiresPermissions("industry")
	@RequestMapping("/tenant/industry/view_list")
	public String list(Pageable pageable, @RequestParam(value="pid",defaultValue = "1") Integer pid,ModelMap model) {

		if (pageable==null){
			pageable=new Pageable();
		}
		if (pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.asc("code"));
		}
		Tenant tenant = tenantService.cur();
		if (tenant != null) {
		  pageable.getFilters().add(Filter.eq("tenant.id", tenant.getId()));
		}
		pageable.getFilters().add(Filter.eq("parent.id", pid));
		Page<Industry> pagination = manager.page(pageable);
		List<Industry> tops = manager.findByTops(pid);
		if (tops.isEmpty()&&pid==1){
			Industry root=new Industry();
			root.setName("根节点");
			root.setLevelInfo(1);
			root.setCode("");
			root.setSortNum(0);
			manager.save(root);
		}
		model.addAttribute("tops",tops);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("pid", pid);
		return getView("industry/list");
	}

	@RequiresPermissions("industry")
	@RequestMapping("/tenant/industry/view_add")
	public String add(ModelMap model) {
		return getView("industry/add");
	}

	@RequiresPermissions("industry")
	@RequestMapping("/tenant/industry/view_edit")
	public String edit(Pageable pageable,Integer id,  ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return getView("industry/edit");
	}

	@RequiresPermissions("industry")
	@RequestMapping("/tenant/industry/view_view")
	public String view(Integer id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return  getView("industry/view");
	}

	@RequiresPermissions("industry")
	@RequestMapping("/tenant/industry/model_save")
	public String save(Pageable pageable,Industry bean,ModelMap model) {
	
	    String view="redirect:/tenant/industry/view_list.htm?pid=" + bean.getParentId() + "&pageNumber=" + pageable.getPageNumber();
		try {
			bean.setTenant(tenantService.cur());
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view=getView("industry/add");
		}
		return view;
	}

	@RequiresPermissions("industry")
	@RequestMapping("/tenant/industry/model_update")
	public String update(Pageable pageable, Industry bean,  RedirectAttributes redirectAttributes, ModelMap model) {

		String view=REDIRECT_LIST_HTML;
		try {
			manager.update(bean);
			initRedirectData(pageable, redirectAttributes);
			Industry temp=manager.findById(bean.getId());
			if (temp!=null){
				redirectAttributes.addAttribute("pid",temp.getParentId());
			}
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
			model.addAttribute("page", pageable);
			view=getView("industry/edit");
		}
		return view;
	}
	@RequiresPermissions("industry")
	@RequestMapping("/tenant/industry/model_delete")
	public String delete(Pageable pageable, Integer id, RedirectAttributes redirectAttributes) {

		String view=REDIRECT_LIST_HTML;
		try {
			initRedirectData(pageable, redirectAttributes);
			Industry temp=manager.findById(id);
			if (temp!=null){
				redirectAttributes.addAttribute("pid",temp.getParentId());
			}
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return view;
	}

	@RequiresPermissions("industry")
	@RequestMapping("/tenant/industry/model_deletes")
	public String deletes(Pageable pageable, Integer[] ids,RedirectAttributes redirectAttributes) {

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