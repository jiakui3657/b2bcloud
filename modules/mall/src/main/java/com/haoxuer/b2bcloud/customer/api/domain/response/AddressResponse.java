package com.haoxuer.b2bcloud.customer.api.domain.response;

import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

@Data
public class AddressResponse extends ResponseObject {

    private Long id;

    private String name;

    private String phone;

    private String tel;

    private String address;

    private Double lat;

    private Double lng;

    private String note;
}
