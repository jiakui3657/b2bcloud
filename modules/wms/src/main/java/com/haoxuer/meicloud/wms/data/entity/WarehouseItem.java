package com.haoxuer.meicloud.wms.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "仓库", add = "添加仓库", list = "仓库列表", update = "更新仓库")
@Entity
@Table(name = "bs_tenant_wms_warehouse_item")
public class WarehouseItem extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Good good;

    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse warehouse;

    private Integer num;


}
