package com.haoxuer.b2bcloud.order.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "换货单", add = "换货单", list = "换货单", update = "换货单")
@Entity
@Table(name = "bs_tenant_order_exchange")
public class OrderExchange extends TenantEntity {

    @FormFieldAnnotation(title = "换货单编号", sortNum = "1", grid = true, col = ColType.col_2)
    private String no;

    @FormFieldAnnotation(title = "客户名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String name;

    @FormFieldAnnotation(title = "状态", sortNum = "1", grid = true, col = ColType.col_2)
    private String state;
}
