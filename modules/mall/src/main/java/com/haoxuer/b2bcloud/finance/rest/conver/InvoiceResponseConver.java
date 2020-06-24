package com.haoxuer.b2bcloud.finance.rest.conver;

import com.haoxuer.b2bcloud.finance.api.domain.response.InvoiceResponse;
import com.haoxuer.b2bcloud.finance.data.entity.Invoice;
import com.haoxuer.discover.data.rest.core.Conver;

public class InvoiceResponseConver implements Conver<InvoiceResponse, Invoice> {
    @Override
    public InvoiceResponse conver(Invoice source) {
        InvoiceResponse result = new InvoiceResponse();
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
