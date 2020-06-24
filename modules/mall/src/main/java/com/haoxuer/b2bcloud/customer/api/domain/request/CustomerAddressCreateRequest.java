package com.haoxuer.b2bcloud.customer.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年04月30日15:32:18.
*/

@Data
public class CustomerAddressCreateRequest extends TenantRequest {

    private Long user;

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