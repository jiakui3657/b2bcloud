package com.haoxuer.meicloud.wms.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantCatalogEntity;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.enums.StoreState;
import lombok.Data;

import javax.persistence.*;

/**
 * 货物
 */
@Data
@FormAnnotation(title = "物品分类", add = "添加物品分类", list = "物品分类列表", update = "更新物品分类")
@Entity
@Table(name = "bs_tenant_wms_warehouse_good_catalog")
public class GoodCatalog extends TenantCatalogEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    private GoodCatalog parent;

    private String logo;

    private StoreState storeState;

    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
