package com.haoxuer.b2bcloud.customer.api.apis;


import com.haoxuer.b2bcloud.customer.api.domain.list.CustomerAddressList;
import com.haoxuer.b2bcloud.customer.api.domain.page.CustomerAddressPage;
import com.haoxuer.b2bcloud.customer.api.domain.request.*;
import com.haoxuer.b2bcloud.customer.api.domain.response.AddressResponse;
import com.haoxuer.b2bcloud.customer.api.domain.response.CustomerAddressResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;

public interface CustomerAddressApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    CustomerAddressResponse create(CustomerAddressCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    CustomerAddressResponse update(CustomerAddressUpdateRequest request);

    /**
     * 删除
     *
     * @param request
     * @return
     */
    CustomerAddressResponse delete(CustomerAddressDeleteRequest request);


    /**
     * @param request
     * @return
     */
    CustomerAddressList list(CustomerAddressListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    CustomerAddressPage search(CustomerAddressSearchRequest request);


}