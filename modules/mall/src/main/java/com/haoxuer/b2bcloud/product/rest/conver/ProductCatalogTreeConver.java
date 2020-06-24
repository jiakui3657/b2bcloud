package com.haoxuer.b2bcloud.product.rest.conver;

import com.haoxuer.b2bcloud.mall.api.domain.simple.TreeSimple;
import com.haoxuer.b2bcloud.mall.data.conver.CatalogSimpleConver;
import com.haoxuer.b2bcloud.product.data.entity.ProductCatalog;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.rest.core.Conver;

public class ProductCatalogTreeConver implements Conver<TreeSimple, ProductCatalog> {
    @Override
    public TreeSimple conver(ProductCatalog source) {
        TreeSimple result=new TreeSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        if (source.getChild() != null && source.getChild().size() > 0) {
            result.setChildren(ConverResourceUtils.converCollect(source.getChild(), new ProductCatalogTreeConver()));
        }
        return result;
    }
}
