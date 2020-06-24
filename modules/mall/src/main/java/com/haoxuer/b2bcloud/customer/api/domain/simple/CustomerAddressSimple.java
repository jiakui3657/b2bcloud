package com.haoxuer.b2bcloud.customer.api.domain.simple;


import java.io.Serializable;
import lombok.Data;

/**
*
* Created by imake on 2020年04月30日15:32:18.
*/

@Data
public class CustomerAddressSimple implements Serializable {

    private Long id;

    private String name;

    private String phone;

    private String tel;

    private String address;

    private Double lat;

    private Double lng;

    private String code;

    private String note;

    private boolean defaultState;
}