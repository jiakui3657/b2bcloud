package com.haoxuer.b2bcloud.customer.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "客户标签", add = "客户标签", list = "客户标签", update = "客户标签")
@Entity
@Table(name = "bs_tenant_mall_customer_to_tag")
public class CustomerToTag extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerTag tag;
}
