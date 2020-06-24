package com.haoxuer.b2bcloud.customer.api.apis;

import com.haoxuer.b2bcloud.customer.api.domain.page.AddressPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.AddressRequest;
import com.haoxuer.b2bcloud.customer.api.domain.response.AddressResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantPageRequest;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;
import com.haoxuer.discover.rest.base.ResponseObject;

public interface AddressApi {

    AddressPage page(TenantPageRequest request);

    ResponseObject add(AddressRequest request);

    ResponseObject delete(ViewRequest request);

    ResponseObject update(AddressRequest request);

    ResponseObject updateSingle(AddressRequest request);

    AddressResponse info(TenantRequest request);

}
