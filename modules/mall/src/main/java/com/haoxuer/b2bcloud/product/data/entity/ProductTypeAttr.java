package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.b2bcloud.store.data.entity.Store;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@FormAnnotation(title = "商品规格属性表", add = "商品规格属性表", list = "商品规格属性表", update = "商品规格属性表")
@Entity
@Table(name = "bs_tenant_product_type")
public class ProductTypeAttr extends TenantEntity {

    public static final Short PLATFORM = Short.valueOf((short)1);
    public static final Short STORE = Short.valueOf((short)2);
    public static final Integer VALUE_TYPE_TEXT = 1;
    public static final Integer VALUE_TYPE_RADIO = 2;
    public static final Integer VALUE_TYPE_CHECKBOX = 3;
    public static final Integer VALUE_TYPE_IMAGE = 4;
    public static final int SORTNUM_DEFAULT = 10;
    private Boolean custom;
    private Boolean required;
    private Boolean isSaleAttr;
    private String name;
    private String remark;
    private Short attrType;
    private String attrGroupName;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @OneToMany(mappedBy = "attr",fetch = FetchType.LAZY)
    private List<ProductTypeAttrValue> attrValueList;


}
