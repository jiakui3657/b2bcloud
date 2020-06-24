package com.haoxuer.b2bcloud.customer.data.entity;

import com.haoxuer.b2bcloud.mall.data.entity.BaseUser;
import com.haoxuer.bigworld.member.data.entity.TenantUser;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.annotations.InputType;
import com.haoxuer.discover.user.data.entity.UserRole;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@FormAnnotation(title = "客户", add = "客户", list = "客户", update = "客户")
@Entity
@Table(name = "bs_tenant_user")
public class Customer extends TenantEntity {

    public static Customer fromId(Long id) {
        Customer result = new Customer();
        result.setId(id);
        return result;
    }

    @FormFieldAnnotation(title = "联系人", sortNum = "2", grid = true, col = ColType.col_2)
    private String name;

    @FormFieldAnnotation(title = "客户名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String shop;

    @FormFieldAnnotation(title = "电话", sortNum = "4", grid = true, col = ColType.col_2)
    private String phone;

    @FormFieldAnnotation(title = "客户等级", sortNum = "3", grid = true, col = ColType.col_2)
    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerLevel level;


    @FormFieldAnnotation(title = "客户经理", sortNum = "5", grid = true, col = ColType.col_2)
    private String manager;

    @FormFieldAnnotation(title = "备注", sortNum = "7", grid = false, col = ColType.col_2, type = InputType.textarea)
    private String note;

    @FormFieldAnnotation(title = "详细地址", sortNum = "6", grid = false, col = ColType.col_2)
    private String address;

    private Double lat;

    private Double lng;

    private Long addressId;

    private String avatar;

    private String no;


    private Integer dataType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bs_tenant_user_tag_links", joinColumns = {@JoinColumn(name = "user_id")})
    private Set<CustomerTag> roles = new HashSet<CustomerTag>();


}
