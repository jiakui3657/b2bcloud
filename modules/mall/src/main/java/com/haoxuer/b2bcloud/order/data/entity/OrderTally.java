package com.haoxuer.b2bcloud.order.data.entity;


import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerAddress;
import com.haoxuer.bigworld.tenant.annotation.SearchItem;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@FormAnnotation(title = "理货单", add = "理货单", list = "理货单", update = "理货单")
@Entity
@Table(name = "bs_tenant_order_tally")
public class OrderTally extends TenantEntity {

    @FormFieldAnnotation(title = "编号", sortNum = "1", grid = true, col = ColType.col_2)
    private String no;


    @SearchItem(label = "收货人",name = "consignee",key = "consignee",sortNum = "1")
    @Column(length = 20)
    @FormFieldAnnotation(title = "收货人", sortNum = "2", grid = true, col = ColType.col_2)
    private String consignee;

    @SearchItem(label = "联系电话",name = "phone",key = "phone",sortNum = "2")
    @Column(length = 20)
    @FormFieldAnnotation(title = "联系电话", sortNum = "3", grid = true, col = ColType.col_2)
    private String phone;

    @Column(length = 100)
    @FormFieldAnnotation(title = "收货地址", sortNum = "4", grid = true, col = ColType.col_2)
    private String address;

    @Column(length = 500)
    @FormFieldAnnotation(title = "备注", sortNum = "5", grid = true, col = ColType.col_2)
    private String note;

    @FormFieldAnnotation(title = "状态", sortNum = "6", grid = true, col = ColType.col_2)
    private String state;

    private Integer size;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerAddress customerAddress;

    @SearchItem(name = "customer", key = "customer.name", label = "客服姓名")
    @FormFieldAnnotation(title = "客服姓名", sortNum = "4", grid = true, col = ColType.col_2)
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tally")
    private List<OrderTallyItem> items;
}
