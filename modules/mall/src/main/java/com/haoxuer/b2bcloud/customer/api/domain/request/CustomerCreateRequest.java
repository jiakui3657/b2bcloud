package com.haoxuer.b2bcloud.customer.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import lombok.Data;

import java.util.List;

/**
*
* Created by imake on 2020年04月28日18:51:06.
*/

@Data
public class CustomerCreateRequest extends TenantRequest {

    private String name;

    private String no;

    private String password;

    private String phone;

    private String shop;

    private String sex;

    private List<Long> labels;


    private String job;

    private String avatar;
}