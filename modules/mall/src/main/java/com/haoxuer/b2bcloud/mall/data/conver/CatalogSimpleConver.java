package com.haoxuer.b2bcloud.mall.data.conver;

import com.haoxuer.b2bcloud.mall.api.domain.simple.TreeSimple;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsCatalog;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.rest.core.Conver;

public class CatalogSimpleConver implements Conver<TreeSimple, GoodsCatalog> {
    @Override
    public TreeSimple conver(GoodsCatalog source) {
        TreeSimple result=new TreeSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        if (source.getChild() != null && source.getChild().size() > 0) {
            result.setChildren(ConverResourceUtils.converCollect(source.getChild(), new CatalogSimpleConver()));
        }
        return result;
    }
}
