package com.haoxuer.b2bcloud.finance.rest.conver;

import com.haoxuer.b2bcloud.finance.api.domain.simple.InvoiceSimple;
import com.haoxuer.b2bcloud.finance.data.entity.Invoice;
import com.haoxuer.discover.data.rest.core.Conver;

public class InvoiceSimpleConver implements Conver<InvoiceSimple, Invoice> {
    @Override
    public InvoiceSimple conver(Invoice source) {
        InvoiceSimple result = new InvoiceSimple();
        result.setId(source.getId());
        result.setAddress(source.getAddress());
        result.setPhone(source.getPhone());
        result.setName(source.getName());
        result.setBankNo(source.getBankNo());
        result.setTaxNo(source.getTaxNo());
        result.setBankName(source.getBankName());

        return result;
    }
}
