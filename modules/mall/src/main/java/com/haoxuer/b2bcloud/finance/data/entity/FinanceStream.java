package com.haoxuer.b2bcloud.finance.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "资金流水", add = "资金流水", list = "资金流水", update = "资金流水")
@Entity
@Table(name = "bs_tenant_finance_stream")
public class FinanceStream extends TenantEntity {
}
