package com.haoxuer.b2bcloud.mall.data.conver;

import com.haoxuer.b2bcloud.mall.data.entity.GoodsCatalog;
import com.haoxuer.b2bcloud.mall.data.vo.GoodsCatalogVo;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.rest.core.Conver;

public class GoodsCatalogVoConver implements Conver<GoodsCatalogVo, GoodsCatalog> {
    @Override
    public GoodsCatalogVo conver(GoodsCatalog source) {
        GoodsCatalogVo result = new GoodsCatalogVo();
        result.setId(source.getId());
        result.setText(source.getName());
        if (source.getChild() != null && source.getChild().size() > 0) {
            result.setNodes(ConverResourceUtils.converCollect(source.getChild(), new GoodsCatalogVoConver()));
        }
        return result;
    }
}
