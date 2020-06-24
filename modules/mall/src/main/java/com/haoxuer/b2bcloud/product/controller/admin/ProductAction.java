package com.haoxuer.b2bcloud.product.controller.admin;


import com.haoxuer.b2bcloud.order.vo.ProductVo;
import com.haoxuer.b2bcloud.product.api.apis.ProductApi;
import com.haoxuer.b2bcloud.product.api.domain.page.ProductPage;
import com.haoxuer.b2bcloud.product.api.domain.request.ProductAddRequest;
import com.haoxuer.b2bcloud.product.api.domain.request.ProductPageRequest;
import com.haoxuer.b2bcloud.product.api.domain.response.ProductResponse;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.utils.FilterUtils;
import com.haoxuer.b2bcloud.product.data.so.ProductSo;
import com.haoxuer.discover.rest.base.ResponseObject;
import com.haoxuer.discover.views.excel.JxlsExcelView;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.haoxuer.bigworld.tenant.controller.admin.TenantBaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import  com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.b2bcloud.product.data.service.ProductService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import com.haoxuer.bigworld.tenant.data.service.TenantService;
import com.haoxuer.discover.data.page.Filter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
*
* Created by imake on 2020年03月23日16:15:52.
*/


@Scope("prototype")
@Controller
public class ProductAction extends TenantBaseAction {

	public static final String MODEL = "model";

	public static final String REDIRECT_LIST_HTML = "redirect:/tenant/product/view_list.htm";

	private static final Logger log = LoggerFactory.getLogger(ProductAction.class);

	@Autowired
	private ProductService manager;

	@Autowired
	private TenantService tenantService;


	@Autowired
	private ProductApi api;

	@RequiresPermissions("product")
	@RequestMapping("/tenant/product/view_list")
	public String list(Pageable pageable,ProductSo so,ModelMap model) {

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
		Page<Product> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return getView("product/list");
	}

	@RequiresPermissions("product")
	@RequestMapping("/tenant/product/excel_out")
	public ModelAndView excelOut(Pageable pageable, ProductSo so, ModelMap model) {

		if (pageable == null) {
			pageable = new Pageable();
		}
		pageable.getOrders().add(Order.desc("id"));
		pageable.getFilters().addAll(FilterUtils.getFilters(so));

		List<Product> products = manager.list(0, 1000, pageable.getFilters(), pageable.getOrders());
		model.addAttribute("list", products);
		return new ModelAndView(new JxlsExcelView("excels/products.xls", "products"), model);
	}

	@RequiresPermissions("product")
	@RequestMapping("/tenant/product/excel_in")
	public String excelIn(MultipartFile file) {
		try {
			HSSFWorkbook wb = null;
			POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
			wb = new HSSFWorkbook(fs);

			List<ProductVo> vos = new ArrayList<>();
			if (wb != null) {
				HSSFSheet sheet = wb.getSheetAt(0);
				int rowNum = sheet.getLastRowNum();
				for (int i = 1; i <= rowNum; i++) {
					HSSFRow row = sheet.getRow(i);
					HSSFCell cell3 = row.getCell(1);
					if (cell3 != null) {
						cell3.setCellType(CellType.STRING);
					}
					HSSFCell cell4 = row.getCell(2);
					if (cell4 != null) {
						cell4.setCellType(CellType.STRING);

					}

					String id = getCellFormatValue(row.getCell(0));
					String catalog = getCellFormatValue(row.getCell(1));
					String name = getCellFormatValue(row.getCell(2));
					String price = getCellFormatValue(row.getCell(3));
					String demo = getCellFormatValue(row.getCell(4));
					String unit = getCellFormatValue(row.getCell(5));
					ProductVo vo = new ProductVo();
					vo.setId(id);
					vo.setCatalog(catalog);
					vo.setName(name);
					vo.setPrice(price);
					vo.setDemo(demo);
					vo.setUnit(unit);
					vos.add(vo);
				}
			}
			manager.updates(vos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return REDIRECT_LIST_HTML;
	}

	private String getCellFormatValue(HSSFCell cell) {
		String cellvalue = "";
		if (cell == null) {
			return "";
		}
		if (cell.getCellType() == CellType.STRING) {
			cellvalue = cell.getRichStringCellValue().getString();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			cellvalue = String.valueOf(cell.getNumericCellValue());

		} else if (cell.getCellType() == CellType.FORMULA) {
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				cellvalue = sdf.format(date);
			}
		} else {
			cell.setCellType(CellType.STRING);
			cellvalue = cell.getStringCellValue();
		}
		return cellvalue;

	}

	@RequiresPermissions("product")
	@RequestMapping("/tenant/product/view_add")
	public String add(ModelMap model) {
		return  getView("product/add");
	}

	@RequiresPermissions("product")
	@RequestMapping("/tenant/product/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return getView("product/edit");
	}
	@RequiresPermissions("product")
	@RequestMapping("/tenant/product/online")
	public String online(Long id, Integer no, RedirectAttributes attributes) {
		manager.online(id);
		attributes.addAttribute("pageNumber", no);
		return REDIRECT_LIST_HTML;
	}

	@RequiresPermissions("product")
	@RequestMapping("/tenant/product/offline")
	public String offline(Long id, Integer no, RedirectAttributes attributes) {
		manager.offline(id);
		attributes.addAttribute("pageNumber", no);
		return REDIRECT_LIST_HTML;
	}
	@RequiresPermissions("product")
	@RequestMapping("/tenant/product/view_view")
	public String view(Long id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return getView("product/view");
	}

	@RequiresPermissions("product")
	@RequestMapping("/tenant/product/model_save")
	public String save(Product bean,ModelMap model) {
	
	    String view=REDIRECT_LIST_HTML;
		try {
			bean.setTenant(tenantService.cur());
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view=getView("product/add");
		}
		return view;
	}

	@RequiresPermissions("product")
	@RequestMapping("/tenant/product/model_update")
	public String update(Pageable pageable, Product bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view=REDIRECT_LIST_HTML;
		try {
			manager.update(bean);
			initRedirectData(pageable, redirectAttributes);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view=getView("product/edit");
		}
		return view;
	}
	@RequiresPermissions("product")
	@RequestMapping("/tenant/product/model_delete")
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

	@RequiresPermissions("product")
	@RequestMapping("/tenant/product/model_deletes")
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