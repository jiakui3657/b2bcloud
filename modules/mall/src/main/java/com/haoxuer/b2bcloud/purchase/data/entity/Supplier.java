package com.haoxuer.b2bcloud.purchase.data.entity;

import com.haoxuer.bigworld.tenant.annotation.SearchItem;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.annotations.InputType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "供应商", add = "供应商", list = "供应商", update = "供应商")
@Entity
@Table(name = "bs_tenant_purchase_supplier")
public class Supplier extends TenantEntity {

    @SearchItem(label = "联系人",placeholder = "请输入联系人",key = "name",sortNum = "2", name ="name",type = InputType.text,classType = "String")
    @FormFieldAnnotation(title = "联系人", sortNum = "2", grid = true, col = ColType.col_1)
    @Column(length = 50)
    private String name;

    @SearchItem(label = "手机号码",placeholder = "请输入手机号码",key = "phone",sortNum = "3", name ="phone",type = InputType.text,classType = "String")
    @FormFieldAnnotation(title = "手机", sortNum = "3", grid = true, col = ColType.col_1)
    private String phone;


    @SearchItem(label = "供货商名称", sortNum = "1", name ="shop",key = "shop",type = InputType.text,classType = "String")
    @FormFieldAnnotation(title = "供货商名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String shop;

    @FormFieldAnnotation(title = "座机", sortNum = "4", grid = true, col = ColType.col_1)
    private String tel;

    @FormFieldAnnotation(title = "供货商位置", sortNum = "5", grid = true, col = ColType.col_3)
    private String address;

    private Double lat;

    private Double lng;

    @FormFieldAnnotation(title = "备注", sortNum = "6", grid = false, col = ColType.col_2)
    private String note;
}
