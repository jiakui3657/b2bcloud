package com.haoxuer.b2bcloud.mall.data.service;

import com.haoxuer.b2bcloud.mall.data.entity.Goods;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsSku;
import com.haoxuer.b2bcloud.mall.data.vo.GoodsSpuSkuVo;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年01月17日14:08:58.
*/
public interface GoodsSkuService {

	GoodsSku findById(Long id);

	GoodsSku save(GoodsSku bean);

	GoodsSku update(GoodsSku bean);

	GoodsSku deleteById(Long id);
	
	GoodsSku[] deleteByIds(Long[] ids);
	
	Page<GoodsSku> page(Pageable pageable);
	
	Page<GoodsSku> page(Pageable pageable, Object search);


	List<GoodsSku> list(int first, Integer size, List<Filter> filters, List<Order> orders);

	List<GoodsSku> listSku(long goodsId,long tenantId);

	GoodsSku findSkuByGoodsId(long goodsId);

	void creatGoodsSpuSku(GoodsSpuSkuVo vo, Goods goods);

}