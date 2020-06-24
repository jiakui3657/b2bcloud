package com.haoxuer.b2bcloud.mall.data.entity;

import com.google.common.collect.Lists;
import com.haoxuer.bigworld.tenant.data.entity.TenantCatalogEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@FormAnnotation(title = "商品分类", add = "商品分类", list = "商品分类", update = "商品分类")
@Entity
@Table(name = "bs_tenant_mall_goods_catalog")
public class GoodsCatalog extends TenantCatalogEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private GoodsCatalog parent;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "parent")
    private List<GoodsCatalog> child;

    @Override
    public Integer getParentId() {
        if (parent!=null){
            return parent.getId();
        }
        return null;
    }
}
