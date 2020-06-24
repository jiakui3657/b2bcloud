package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.b2bcloud.product.data.enums.ProductState;
import com.haoxuer.b2bcloud.purchase.data.entity.Supplier;
import com.haoxuer.b2bcloud.store.data.entity.Store;
import com.haoxuer.b2bcloud.store.data.entity.StoreProductCategory;
import com.haoxuer.bigworld.brand.data.entity.Brand;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.enums.StoreState;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Data
@FormAnnotation(title = "商品信息", add = "商品信息", list = "商品信息", update = "商品信息")
@Entity
@Table(name = "bs_tenant_product")
public class Product extends TenantEntity {
    public static Product fromId(Long id) {
        Product result = new Product();
        result.setId(id);
        return result;
    }

    @FormFieldAnnotation(title = "商品编码", sortNum = "1", grid = true, col = ColType.col_2)
    private String barCode;

    @FormFieldAnnotation(title = "商品名称", sortNum = "2", grid = true, col = ColType.col_2)
    private String name;

    @FormFieldAnnotation(title = "商品简介", sortNum = "111", grid = false, col = ColType.col_2)
    private String summary;

    @FormFieldAnnotation(title = "商品简介显示颜色值", sortNum = "3", grid = false, col = ColType.col_2)
    private String summaryColor;
    //是否为销售商品出售  true是   false否
    @FormFieldAnnotation(title = "是否为销售商品出售", sortNum = "4", grid = false, col = ColType.col_2)
    private Boolean sellState;

    @FormFieldAnnotation(title = "是否开票", sortNum = "5", grid = true, col = ColType.col_2)
    private Boolean invoice;
    //商品状态,0-仓库中  1-待审核  2- 审核不通过  3-出售中(审核通过、上架)  4-下架（违规下架）  5 -回收站
    @FormFieldAnnotation(title = "商品状态", sortNum = "6", grid = true, col = ColType.col_1)
    private Integer status;


    @FormFieldAnnotation(title = "启用商品规格", sortNum = "7", grid = false, col = ColType.col_2)
    private Boolean hasSku;

    @FormFieldAnnotation(title = "号", sortNum = "8", grid = true, col = ColType.col_2)
    private String itemNumber;

    @FormFieldAnnotation(title = "销售价", sortNum = "9", grid = true, col = ColType.col_1)
    private BigDecimal salePrice;

    @FormFieldAnnotation(title = "市场价", sortNum = "10", grid = true, col = ColType.col_1)
    private BigDecimal marketPrice;

    @FormFieldAnnotation(title = "成本价", sortNum = "11", grid = true, col = ColType.col_1)
    private BigDecimal costPrice;

    @FormFieldAnnotation(title = "vip价", sortNum = "11", grid = true, col = ColType.col_1)
    private BigDecimal vipPrice;

    @FormFieldAnnotation(title = "库存量", sortNum = "12", grid = true, col = ColType.col_1)
    private Integer inventory;

    @FormFieldAnnotation(title = "库存预警值", sortNum = "13", grid = true, col = ColType.col_1)
    private Integer warningValue;

    private Date shelfTime;

    @FormFieldAnnotation(title = "毛重", sortNum = "14", grid = false, col = ColType.col_1)
    private Double weight;

    @FormFieldAnnotation(title = "体积", sortNum = "15", grid = false, col = ColType.col_1)
    private Double volume;

    @FormFieldAnnotation(title = "净重", sortNum = "14", grid = false, col = ColType.col_1)
    private Double netWeight;


    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @FormFieldAnnotation(title = "商品关联所属分类", sortNum = "1", grid = true, col = ColType.col_2)
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductCatalog catalog;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    private String logo;

    private String unit;

    private String demo;

    @FormFieldAnnotation(title = "商品介绍", sortNum = "1", grid = true, col = ColType.col_2)
    private String note;

    private Integer sortNum;

    private StoreState storeState;

    private ProductState state;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductLabel label;

    @ManyToOne(fetch = FetchType.LAZY)
    private Supplier supplier;


    @FormFieldAnnotation(title = "店铺内商品分类", sortNum = "1", grid = true, col = ColType.col_2)
    private StoreProductCategory storeProductCategory;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bs_tenant_product_tag_links",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<ProductTag> tags;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductSku> skus;

    //虚拟卡密模板id;只有当商品类型为虚拟情况时才有此值
//    private ProductVirtualCardTpl virtualCardTpl;
//
//    private ProductExt ext;
//    private ProductStatistic statistic;
//    private ProductTxt txt;
//
//    private StoreExpressTpl expressTpl;

//    private List<ProductResource> resources;
//    private List<ProductSkuAttr> skuAttrs;
//    private List<ProductAttr> productAttrs;
//    private List<ProductCombon> combons;
//    private List<Promote> promotes;
}
