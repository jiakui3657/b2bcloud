package com.haoxuer.b2bcloud.store.rest.conver;

import com.haoxuer.b2bcloud.store.api.domain.response.StoreResponse;
import com.haoxuer.b2bcloud.store.data.entity.Store;
import com.haoxuer.discover.data.rest.core.Conver;

public class StoreResponseConver implements Conver<StoreResponse, Store> {
    @Override
    public StoreResponse conver(Store source) {
        StoreResponse result = new StoreResponse();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
