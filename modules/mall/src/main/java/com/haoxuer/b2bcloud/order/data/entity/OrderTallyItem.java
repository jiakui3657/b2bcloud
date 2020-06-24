package com.haoxuer.b2bcloud.order.data.entity;


import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "理货子项", add = "理货子项", list = "理货子项", update = "理货子项")
@Entity
@Table(name = "bs_tenant_order_tally_item")
public class OrderTallyItem extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderTally tally;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderItem orderItem;

    @FormFieldAnnotation(title = "理货数量", sortNum = "1", grid = true, col = ColType.col_2)
    private Integer size;



}
