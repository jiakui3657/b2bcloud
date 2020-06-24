package com.haoxuer.b2bcloud.finance.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.trade.data.entity.TradeAccount;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@FormAnnotation(title = "客户", add = "客户", list = "客户", update = "客户")
@Entity
@Table(name = "bs_tenant_user")
public class FinanceAccount extends TenantEntity {

    /**
     * 资金账户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount account;

    /**
     * 积分
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount score;

    /**
     * 费用包
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount fee;

    /**
     * 返利账户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount rebate;

    //信用额度
    private BigDecimal credit;

    @FormFieldAnnotation(title = "联系人", sortNum = "2", grid = true, col = ColType.col_2)
    private String name;

    @FormFieldAnnotation(title = "客户名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String shop;

    @FormFieldAnnotation(title = "电话", sortNum = "4", grid = true, col = ColType.col_2)
    private String phone;

    @FormFieldAnnotation(title = "账号", sortNum = "3", grid = true, col = ColType.col_2)
    private String no;

    private Integer dataType;

}
