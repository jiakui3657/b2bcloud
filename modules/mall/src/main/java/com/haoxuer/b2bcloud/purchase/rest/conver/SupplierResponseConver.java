package com.haoxuer.b2bcloud.purchase.rest.conver;

import com.haoxuer.b2bcloud.purchase.api.domain.response.SupplierResponse;
import com.haoxuer.b2bcloud.purchase.data.entity.Supplier;
import com.haoxuer.discover.data.rest.core.Conver;

public class SupplierResponseConver implements Conver<SupplierResponse, Supplier> {
    @Override
    public SupplierResponse conver(Supplier source) {
        SupplierResponse result = new SupplierResponse();
        result.setId(source.getId());
        result.setShop(source.getShop());
        result.setNote(source.getNote());
        result.setAddress(source.getAddress());
        result.setLng(source.getLng());
        result.setPhone(source.getPhone());
        result.setName(source.getName());
        result.setTel(source.getTel());
        result.setLat(source.getLat());
        return result;
    }
}
