package com.haoxuer.b2bcloud.finance.data.entity;


import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "账单", add = "账单", list = "账单", update = "账单")
@Entity
@Table(name = "bs_tenant_finance_bill")
public class Bill extends TenantEntity {
}
