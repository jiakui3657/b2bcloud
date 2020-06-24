package com.haoxuer.b2bcloud.customer.data.entity;

import com.haoxuer.b2bcloud.mall.data.entity.BaseUser;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.trade.data.entity.TradeAccount;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


@Data
@FormAnnotation(title = "客户", add = "客户", list = "客户", update = "客户")
@Entity
public class CustomerAccount extends BaseUser {


    @FormFieldAnnotation(title = "联系人", sortNum = "2", grid = true, col = ColType.col_2)
    private String name;

    @FormFieldAnnotation(title = "客户名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String shop;

    @FormFieldAnnotation(title = "电话", sortNum = "4", grid = true, col = ColType.col_2)
    private String phone;

    @FormFieldAnnotation(title = "客户等级", sortNum = "3", grid = true, col = ColType.col_2)
    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerLevel level;


    @FormFieldAnnotation(title = "客户经理", sortNum = "5", grid = true, col = ColType.col_1)
    private String manager;

    @FormFieldAnnotation(title = "余额", sortNum = "6", grid = true, col = ColType.col_1)
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount account;
}
