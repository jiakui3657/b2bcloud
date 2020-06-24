package com.haoxuer.b2bcloud.purchase.rest.conver;

import com.haoxuer.b2bcloud.purchase.api.domain.simple.SupplierSimple;
import com.haoxuer.b2bcloud.purchase.data.entity.Supplier;
import com.haoxuer.discover.data.rest.core.Conver;

public class SupplierSimpleConver implements Conver<SupplierSimple, Supplier> {
    @Override
    public SupplierSimple conver(Supplier source) {
        SupplierSimple result = new SupplierSimple();
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
