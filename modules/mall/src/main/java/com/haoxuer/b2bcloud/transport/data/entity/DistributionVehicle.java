package com.haoxuer.b2bcloud.transport.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@FormAnnotation(title = "配送车辆", add = "配送车辆", list = "配送车辆", update = "配送车辆")
@Entity
@Table(name = "bs_tenant_transport_distribution_vehicle")
public class DistributionVehicle extends TenantEntity {

    @FormFieldAnnotation(title = "车牌号", sortNum = "5", grid = true, col = ColType.col_2)
    private String no;

    @ManyToOne(fetch = FetchType.LAZY)
    @FormFieldAnnotation(title = "车型", sortNum = "5", grid = true, col = ColType.col_2)
    private VehicleType vehicleType;

    @FormFieldAnnotation(title = "承重", sortNum = "5", grid = true, col = ColType.col_2)
    private BigDecimal bearing;

    @FormFieldAnnotation(title = "备注", sortNum = "5", grid = true, col = ColType.col_4)
    private String note;
}
