package com.haoxuer.b2bcloud.store.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantCatalogEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.*;


@Data
@FormAnnotation(title = "门店商品分类", add = "门店商品分类", list = "门店商品分类", update = "门店商品分类")
@Entity
@Table(name = "bs_tenant_store_product_category")
public class StoreProductCategory extends TenantCatalogEntity {

    @Column(name = "showState")
    private Boolean show;

    @Column(name = "topState")
    private Boolean top;

    private String title;

    private String keywords;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    private StoreProductCategory parent;

    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
