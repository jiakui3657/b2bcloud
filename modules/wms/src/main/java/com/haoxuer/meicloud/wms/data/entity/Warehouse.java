package com.haoxuer.meicloud.wms.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.annotations.InputType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "仓库", add = "添加仓库", list = "仓库列表", update = "更新仓库")
@Entity
@Table(name = "bs_tenant_wms_warehouse")
public class Warehouse  extends TenantEntity {

    @FormFieldAnnotation(title = "仓库名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String name;

    @FormFieldAnnotation(title = "仓库类型", sortNum = "2", grid = true, col = ColType.col_2)
    private WarehouseCatalog catalog;

    @FormFieldAnnotation(title = "备注", sortNum = "4", grid = true, col = ColType.col_4)
    private String note;

    @FormFieldAnnotation(title = "地址", sortNum = "3", grid = true, col = ColType.col_2)
    private String address;

    private Float lat;

    private Float lng;
}
