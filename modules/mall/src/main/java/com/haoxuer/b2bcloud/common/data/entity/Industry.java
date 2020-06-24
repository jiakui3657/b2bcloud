package com.haoxuer.b2bcloud.common.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantCatalogEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "行业", add = "行业", list = "行业", update = "行业")
@Entity
@Table(name = "bs_tenant_common_industry")
public class Industry extends TenantCatalogEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Industry parent;


    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
