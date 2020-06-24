package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantCatalogEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@FormAnnotation(title = "商品信息", add = "商品信息", list = "商品信息", update = "商品信息")
@Entity
@Table(name = "bs_tenant_product_catalog")
public class ProductCatalog extends TenantCatalogEntity {

    @FormFieldAnnotation(title = "类", sortNum = "1", grid = true, col = ColType.col_2)
    private String nameAlias;

    @FormFieldAnnotation(title = "保证金", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal bondPrice;

    @FormFieldAnnotation(title = "佣金比例", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal commissionRate;

    @Column(name = "showState")
    @FormFieldAnnotation(title = "是否显示", sortNum = "1", grid = true, col = ColType.col_2)
    private Boolean show;

    @FormFieldAnnotation(title = "是否为虚分类", sortNum = "1", grid = true, col = ColType.col_2)
    private Boolean virtualState;

    @FormFieldAnnotation(title = "分类页标题", sortNum = "1", grid = true, col = ColType.col_2)
    private String title;

    @FormFieldAnnotation(title = "分类页关键词", sortNum = "1", grid = true, col = ColType.col_2)
    private String keywords;

    @FormFieldAnnotation(title = "分类模板", sortNum = "1", grid = true, col = ColType.col_2)
    private String templatePath;

    @FormFieldAnnotation(title = "分页类描述", sortNum = "1", grid = true, col = ColType.col_2)
    private String description;
    //修改主营类目消费保证金时间
    private Date consumerBondModTime;

    private Integer productTypeId;

    @FormFieldAnnotation(title = "商品类型", sortNum = "1", grid = true, col = ColType.col_2)
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductType productType;

    @FormFieldAnnotation(title = "分类图标", sortNum = "1", grid = true, col = ColType.col_2)
    private String icon;



    @ManyToOne(fetch = FetchType.LAZY)
    private ProductCatalog parent;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "parent")
    private List<ProductCatalog> Child;

    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }

    // private List<Store> stores;
}
