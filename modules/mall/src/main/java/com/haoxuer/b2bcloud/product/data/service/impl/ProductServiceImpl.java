package com.haoxuer.b2bcloud.product.data.service.impl;

import com.haoxuer.b2bcloud.order.vo.ProductVo;
import com.haoxuer.b2bcloud.product.data.dao.ProductPriceDao;
import com.haoxuer.b2bcloud.product.data.entity.ProductPrice;
import com.haoxuer.bigworld.pay.utils.DateUtils;
import com.haoxuer.discover.data.enums.StoreState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.product.data.dao.ProductDao;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.b2bcloud.product.data.service.ProductService;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import com.haoxuer.discover.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;


/**
* Created by imake on 2020年03月23日16:15:52.
*/


@Scope("prototype")
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductDao dao;

	@Autowired
	private ProductPriceDao priceDao;

	@Override
	public Product online(Long id) {
		Product entity = dao.findById(id);
		if (entity != null) {
			entity.setStoreState(StoreState.normal);
		}
		return entity;
	}

	@Override
	public Product offline(Long id) {
		Product entity = dao.findById(id);
		if (entity != null) {
			entity.setStoreState(StoreState.draft);
		}
		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Product save(Product bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Product update(Product bean) {
		Updater<Product> updater = new Updater<Product>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Product deleteById(Long id) {
		Product bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Product[] deleteByIds(Long[] ids) {
		Product[] beans = new Product[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Product> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Product> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

	@Override
	public Page<Product> page(Pageable pageable,Object search,  List<Long> tags) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable,tags);
	}

	@Override
    public List<Product> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

	@Override
	public void updates(List<ProductVo> vos) {
		for (ProductVo vo : vos) {
			try {
				updateItem(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void updateItem(ProductVo vo) {
		if (StringUtils.hasText(vo.getId())) {
			Double num = Double.valueOf(vo.getId());
			Long id = num.longValue();

			Product product = dao.findById(id);
			if (product != null) {
				product.setName(vo.getName());
				product.setUnit(vo.getUnit());
				product.setDemo(vo.getDemo());

				BigDecimal price = new BigDecimal(vo.getPrice());
				if (!(price.doubleValue() == product.getSalePrice().doubleValue())) {
					ProductPrice productPrice = new ProductPrice();
					productPrice.setPrice(price);
					productPrice.setProduct(product);
					productPrice.setAddDate(new Date());
					productPrice.setKey(DateUtils.format(new Date()));
					priceDao.save(productPrice);
				}
				product.setSalePrice(price);

			}
		}
	}
}