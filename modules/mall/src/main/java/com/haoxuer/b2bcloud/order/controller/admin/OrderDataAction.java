package com.haoxuer.b2bcloud.order.controller.admin;


import com.haoxuer.b2bcloud.order.conver.OrderExcelConver;
import com.haoxuer.b2bcloud.order.vo.OrderExcel;
import com.haoxuer.bigworld.pay.data.enums.PayState;
import com.haoxuer.bigworld.pay.utils.DateUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.utils.FilterUtils;
import com.haoxuer.b2bcloud.order.data.so.OrderDataSo;
import com.haoxuer.discover.views.excel.JxlsExcelView;
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
import  com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.b2bcloud.order.data.service.OrderDataService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import com.haoxuer.discover.data.page.Filter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
*
* Created by imake on 2020年05月08日10:28:40.
*/


@Scope("prototype")
@Controller
public class OrderDataAction extends TenantBaseAction {

	public static final String MODEL = "model";

	public static final String REDIRECT_LIST_HTML = "redirect:/tenant/orderdata/view_list.htm";

	private static final Logger log = LoggerFactory.getLogger(OrderDataAction.class);

	@Autowired
	private OrderDataService manager;

	@Autowired
	private TenantService tenantService;

	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/view_list_data")
	public String listData(Pageable pageable,OrderDataSo so,ModelMap model) {

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
		Page<OrderData> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return getView("orderdata/list");
	}

	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/view_list")
	public String list(Pageable pageable, OrderDataSo so, ModelMap model) {

		if (pageable == null) {
			pageable = new Pageable();
		}
		if (pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
		}
		initDatas(pageable, so, model);

		return getView("orderdata/list");
	}

	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/view_add")
	public String add(ModelMap model) {
		return  getView("orderdata/add");
	}

	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		Tenant tenant=tenantService.cur();
		model.addAttribute(MODEL, manager.findById(tenant.getId(),id));
		model.addAttribute("page", pageable);
		return getView("orderdata/edit");
	}

	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/view_view")
	public String view(Long id,ModelMap model) {
		Tenant tenant=tenantService.cur();
		model.addAttribute(MODEL, manager.findById(tenant.getId(),id));
		return getView("orderdata/view");
	}

	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/model_save")
	public String save(OrderData bean,ModelMap model) {
	
	    String view=REDIRECT_LIST_HTML;
		try {
			bean.setTenant(tenantService.cur());
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view=getView("orderdata/add");
		}
		return view;
	}

	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/model_update")
	public String update(Pageable pageable, OrderData bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view=REDIRECT_LIST_HTML;
		try {
			manager.update(bean);
			initRedirectData(pageable, redirectAttributes);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view=getView("orderdata/edit");
		}
		return view;
	}
	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/model_delete")
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

	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/model_deletes")
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

	@RequiresPermissions("orderinfo")
	@RequestMapping("/tenant/orderdata/today")
	public String today(Pageable pageable, OrderDataSo so, ModelMap model) {

		if (pageable == null) {
			pageable = new Pageable();
		}
		if (pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
		}
		Filter start = Filter.ge("addDate", DateUtils.begin(new Date()));
		start.setPrefix("start");
		pageable.getFilters().add(start);

		Filter end = Filter.le("addDate", DateUtils.end(new Date()));
		end.setPrefix("end");
		pageable.getFilters().add(end);
		initDatas(pageable, so, model);
		return getView("orderdata/today");
	}
	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/excels")
	public ModelAndView excels(Pageable pageable, OrderDataSo so, ModelMap model) {

		if (pageable == null) {
			pageable = new Pageable();
		}
		if (pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
		}
		if (so.getBeginDate() != null) {
			so.setBeginDate(DateUtils.begin(so.getBeginDate()));
		}
		if (so.getEndDate() != null) {
			so.setEndDate(DateUtils.end(so.getEndDate()));
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));

		List<OrderData> products = manager.list(0, 1000, pageable.getFilters(), pageable.getOrders());

		List<OrderExcel> ls=new ArrayList<>();
		for (OrderData product : products) {
			List<OrderExcel> es = new OrderExcelConver().conver(product);
			if (es!=null){
				ls.addAll(es);
			}
		}
		model.addAttribute("list", ls);

		return new ModelAndView(new JxlsExcelView("excels/orders.xls", "订单"), model);
	}

	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/excelstoday")
	public ModelAndView todayExcel(Pageable pageable, String day, ModelMap model) {


		//model.addAttribute("list", staticService.today(day));

		return new ModelAndView(new JxlsExcelView("excels/productstatic.xls", "productstatic"), model);
	}

	private void initDatas(Pageable pageable, OrderDataSo so, ModelMap model) {
		pageable.getFilters().add(Filter.eq("payState", PayState.success));
		if (so.getBeginDate() != null) {
			so.setBeginDate(DateUtils.begin(so.getBeginDate()));
		}
		if (so.getEndDate() != null) {
			so.setEndDate(DateUtils.end(so.getEndDate()));
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<OrderData> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		model.addAttribute("money", manager.sum(pageable.getFilters()));
	}

	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/add-goods-list")
	public String addGoodList(Pageable pageable,OrderDataSo so,ModelMap model) {

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
		Page<OrderData> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return getView("orderdata/add-goods-list");
	}

	@RequiresPermissions("orderdata")
	@RequestMapping("/tenant/orderdata/goods-buy-cart")
	public String goodsBuyCart(Pageable pageable,OrderDataSo so,ModelMap model) {

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
		Page<OrderData> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return getView("orderdata/goods-buy-cart");
	}

}