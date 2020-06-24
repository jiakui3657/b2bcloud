package com.haoxuer.meicloud.wms.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.meicloud.wms.data.enums.BillType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "单据", add = "添加单据", list = "单据列表", update = "更新单据")
@Entity
@Table(name = "bs_tenant_wms_warehouse_bill")
public class Bill extends TenantEntity {

    private String sn;

    private String note;

    private BillType billType;


}
