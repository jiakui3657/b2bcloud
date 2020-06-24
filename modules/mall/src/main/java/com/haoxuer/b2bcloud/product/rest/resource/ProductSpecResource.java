package com.haoxuer.b2bcloud.product.rest.resource;

import com.haoxuer.b2bcloud.product.api.apis.ProductSpecApi;
import com.haoxuer.b2bcloud.product.api.domain.list.ProductSpecList;
import com.haoxuer.b2bcloud.product.api.domain.request.ProductSpecValueAddRequest;
import com.haoxuer.b2bcloud.product.data.dao.ProductSpecDao;
import com.haoxuer.b2bcloud.product.data.dao.ProductSpecValueDao;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.b2bcloud.product.data.entity.ProductSpec;
import com.haoxuer.b2bcloud.product.data.entity.ProductSpecValue;
import com.haoxuer.b2bcloud.product.rest.conver.ProductSimpleConver;
import com.haoxuer.b2bcloud.product.rest.conver.ProductSpecConver;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.rest.conver.PageableConver;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.rest.base.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductSpecResource implements ProductSpecApi {

    @Autowired
    private ProductSpecDao specDao;

    @Autowired
    private ProductSpecValueDao valueDao;

    @Override
    public ProductSpecList list(TenantPageRequest request) {
        ProductSpecList result = new ProductSpecList();
        Pageable pageable = new PageableConver().conver(request);
        Page<ProductSpec> page = specDao.page(pageable);

        ConverResourceUtils.converList(result, page.getContent(), new ProductSpecConver());


        return result;
    }

    @Override
    public ResponseObject add(ProductSpecValueAddRequest request) {
        ResponseObject result = new ResponseObject();
        ProductSpec spec = specDao.findById(request.getId());
        if (spec == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        ProductSpecValue bean=new ProductSpecValue();
        bean.setName(request.getName());
        bean.setSortNum(request.getSortNum());
        bean.setSpec(spec);
        valueDao.save(bean);
        return result;
    }
}
