package com.haoxuer.b2bcloud.transport.data.entity;


import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "配送司机", add = "配送司机", list = "配送司机", update = "配送司机")
@Entity
@Table(name = "bs_tenant_transport_driver")
public class Driver extends TenantEntity {

    @FormFieldAnnotation(title = "司机姓名", sortNum = "5", grid = true, col = ColType.col_2)
    private String name;

    @FormFieldAnnotation(title = "电话", sortNum = "5", grid = true, col = ColType.col_2)
    private String phone;

    @FormFieldAnnotation(title = "驾照级别", sortNum = "5", grid = true, col = ColType.col_2)
    private String level;


    @FormFieldAnnotation(title = "备注", sortNum = "5", grid = true, col = ColType.col_4)
    private String note;
}
