package com.haoxuer.b2bcloud.customer.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@FormAnnotation(title = "客户", add = "客户", list = "客户", update = "客户")
@Entity
@Table(name = "bs_tenant_mall_customer_level")
public class CustomerLevel extends TenantEntity {

    private String name;

    private BigDecimal money;

    private BigDecimal rebate;
}
