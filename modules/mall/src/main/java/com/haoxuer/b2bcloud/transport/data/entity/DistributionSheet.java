package com.haoxuer.b2bcloud.transport.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "配送单", add = "配送单", list = "配送单", update = "配送单")
@Entity
@Table(name = "bs_tenant_transport_distribution_sheet")
public class DistributionSheet  extends TenantEntity {

    @FormFieldAnnotation(title = "车牌号", sortNum = "5", grid = true, col = ColType.col_2)
    private String no;
}
