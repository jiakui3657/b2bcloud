package com.haoxuer.b2bcloud.order.data.entity;

import com.haoxuer.b2bcloud.order.data.enums.AuditState;
import com.haoxuer.bigworld.member.data.entity.TenantUser;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.annotations.InputType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@FormAnnotation(title = "退货单", add = "退货单", list = "退货单", update = "退货单")
@Entity
@Table(name = "bs_tenant_order_refund")
public class OrderRefund extends TenantEntity {

    @FormFieldAnnotation(title = "编号", sortNum = "1", grid = true, col = ColType.col_2)
    private String no;

    @FormFieldAnnotation(title = "退货人", sortNum = "1", grid = true, col = ColType.col_2)
    private String name;

    @FormFieldAnnotation(title = "退货人电话", sortNum = "1", grid = true, col = ColType.col_2)
    private String phone;

    @FormFieldAnnotation(title = "退货人金额", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal money;

    @FormFieldAnnotation(title = "退货时间", sortNum = "1", type = InputType.date)
    private Date refundDate;

    @FormFieldAnnotation(title = "订单", sortNum = "1", type = InputType.text)
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderData orderData;

    private AuditState auditState;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "refund")
    private List<OrderRefundItem> items;

    @ManyToOne(fetch = FetchType.LAZY)
    private TenantUser user;
}
