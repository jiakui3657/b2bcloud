package com.haoxuer.b2bcloud.store.rest.conver;

import com.haoxuer.b2bcloud.store.api.domain.simple.StoreSimple;
import com.haoxuer.b2bcloud.store.data.entity.Store;
import com.haoxuer.discover.data.rest.core.Conver;

public class StoreSimpleConver implements Conver<StoreSimple, Store> {
    @Override
    public StoreSimple conver(Store source) {
        StoreSimple result = new StoreSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
