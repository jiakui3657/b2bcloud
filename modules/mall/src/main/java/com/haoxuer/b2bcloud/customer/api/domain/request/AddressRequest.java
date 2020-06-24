package com.haoxuer.b2bcloud.customer.api.domain.request;

import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

@Data
public class AddressRequest extends TenantRequest {

    private Long id;

    private String name;

    private String phone;

    private String tel;

    private String address;

    private Double lat;

    private Double lng;

    private String code;

    private String note;

    private Integer  defaultState;
}
