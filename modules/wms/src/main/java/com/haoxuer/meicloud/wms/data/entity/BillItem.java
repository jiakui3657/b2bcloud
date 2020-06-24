package com.haoxuer.meicloud.wms.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.meicloud.wms.data.enums.BillType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@FormAnnotation(title = "单据项", add = "添加单据项", list = "单据项列表", update = "更新单据项")
@Entity
@Table(name = "bs_tenant_wms_warehouse_bill_item")
public class BillItem extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Bill bill;

    private Integer num;

    @ManyToOne(fetch = FetchType.LAZY)
    private Good good;

    private BigDecimal money;

    private BigDecimal cost;


}
