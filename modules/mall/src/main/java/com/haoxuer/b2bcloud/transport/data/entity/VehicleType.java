package com.haoxuer.b2bcloud.transport.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@FormAnnotation(title = "配送车型", add = "配送车型", list = "配送车型", update = "配送车型")
@Entity
@Table(name = "bs_tenant_transport_vehicle_type")
public class VehicleType extends TenantEntity {

    @FormFieldAnnotation(title = "车型", sortNum = "5", grid = true, col = ColType.col_4)
    private String name;

    @FormFieldAnnotation(title = "车型图标", sortNum = "5", grid = true, col = ColType.col_2)
    private String icon;

    @FormFieldAnnotation(title = "最大承重", sortNum = "5", grid = true, col = ColType.col_2)
    private BigDecimal maxWeight;

    @FormFieldAnnotation(title = "最小发货量", sortNum = "5", grid = true, col = ColType.col_2)
    private BigDecimal minSend;
}
