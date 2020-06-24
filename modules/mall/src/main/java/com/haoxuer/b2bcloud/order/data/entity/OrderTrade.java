package com.haoxuer.b2bcloud.order.data.entity;

import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.b2bcloud.promote.data.entity.Promote;
import com.haoxuer.bigworld.pay.data.enums.PayState;
import com.haoxuer.bigworld.tenant.annotation.SearchItem;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Data
@FormAnnotation(title = "订货会订单", add = "订货会订单", list = "订货会订单", update = "订货会订单")
@Entity
@Table(name = "bs_tenant_order_trade")
public class OrderTrade extends TenantEntity {

    @SearchItem(name = "tradeNo", key = "no", label = "编号")
    @FormFieldAnnotation(title = "编号", sortNum = "1", grid = true, col = ColType.col_2)
    private String no;

    //订货会
    @SearchItem(name = "promote", key = "promote.name", label = "订货会")
    @FormFieldAnnotation(title = "订货会", sortNum = "2", grid = true, col = ColType.col_2)
    @ManyToOne(fetch = FetchType.LAZY)
    private Promote promote;

    @FormFieldAnnotation(title = "支付状态", sortNum = "5", grid = true, col = ColType.col_2)
    private PayState payState;

    @SearchItem(name = "customer", key = "customer.name", label = "客服姓名")
    @FormFieldAnnotation(title = "客服姓名", sortNum = "4", grid = true, col = ColType.col_2)
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @FormFieldAnnotation(title = "金额", sortNum = "3", grid = true, col = ColType.col_2)
    private BigDecimal money;

    @FormFieldAnnotation(title = "实付金额", sortNum = "3", grid = true, col = ColType.col_2)
    private BigDecimal payMoney;

    private String note;

    private Integer productCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trade",cascade = {CascadeType.ALL})
    private List<OrderTradeItem> items;

}
