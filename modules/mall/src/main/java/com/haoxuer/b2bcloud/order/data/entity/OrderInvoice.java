package com.haoxuer.b2bcloud.order.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "发票", add = "发票", list = "发票", update = "发票")
@Entity
@Table(name = "bs_tenant_order_exchange")
public class OrderInvoice extends TenantEntity {
}
