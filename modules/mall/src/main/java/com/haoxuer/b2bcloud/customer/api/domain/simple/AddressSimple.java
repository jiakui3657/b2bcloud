package com.haoxuer.b2bcloud.customer.api.domain.simple;

import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class AddressSimple implements Serializable {

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
