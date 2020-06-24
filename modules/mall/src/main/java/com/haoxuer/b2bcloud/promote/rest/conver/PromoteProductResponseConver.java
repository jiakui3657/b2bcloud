package com.haoxuer.b2bcloud.promote.rest.conver;

import com.haoxuer.b2bcloud.promote.api.domain.response.PromoteProductResponse;
import com.haoxuer.b2bcloud.promote.data.entity.PromoteProduct;
import com.haoxuer.discover.data.rest.core.Conver;

public class PromoteProductResponseConver implements Conver<PromoteProductResponse, PromoteProduct> {
    @Override
    public PromoteProductResponse conver(PromoteProduct source) {
        PromoteProductResponse result = new PromoteProductResponse();
        result.setId(source.getId());
        return result;
    }
}
