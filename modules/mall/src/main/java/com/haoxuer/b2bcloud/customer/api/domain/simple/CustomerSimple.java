package com.haoxuer.b2bcloud.customer.api.domain.simple;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerSimple implements Serializable {

    private Long id;

    private String name;

    private String shop;

    private String phone;

    private String level;

    private String no;

}
