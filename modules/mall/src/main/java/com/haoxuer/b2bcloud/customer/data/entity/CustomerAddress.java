package com.haoxuer.b2bcloud.customer.data.entity;

import com.haoxuer.bigworld.member.data.entity.TenantUser;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@FormAnnotation(title = "收货地址", add = "收货地址", list = "收货地址", update = "收货地址")
@Entity
@Table(name = "bs_tenant_mall_customer_address")
public class CustomerAddress extends TenantEntity {

    @FormFieldAnnotation(title = "收货人姓名", sortNum = "1", grid = true, col = ColType.col_2)
    @Column(length = 30)
    private String name;

    @FormFieldAnnotation(title = "手机号码", sortNum = "1", grid = true, col = ColType.col_2)
    @Column(length = 50)
    private String phone;

    @FormFieldAnnotation(title = "座机", sortNum = "1", grid = true, col = ColType.col_2)
    @Column(length = 20)
    private String tel;

    @FormFieldAnnotation(title = "详细地址", sortNum = "1", grid = true, col = ColType.col_2)
    @Column(length = 50)
    private String address;

    private Double lat;

    private Double lng;

    @FormFieldAnnotation(title = "邮编", sortNum = "1", grid = true, col = ColType.col_2)
    @Column(length = 20)
    private String code;

    @FormFieldAnnotation(title = "备注", sortNum = "1", grid = true, col = ColType.col_2)
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    private Date updateDate;
}
