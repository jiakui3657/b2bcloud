package com.haoxuer.b2bcloud.promote.data.entity;

import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.b2bcloud.product.data.entity.ProductCatalog;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.annotations.InputType;
import com.haoxuer.discover.data.enums.StoreState;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@FormAnnotation(title = "促销", add = "促销", list = "促销", update = "促销")
@Entity
@Table(name = "bs_tenant_promote_info")
public class Promote extends TenantEntity {

    @FormFieldAnnotation(title = "名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String name;

    @FormFieldAnnotation(title = "开始时间" ,type = InputType.date)
    private Date beginDate;

    @FormFieldAnnotation(title = "结束时间",type = InputType.date)
    private Date endDate;

    //活动类型(1 单品折扣  2 单品一口价  3 满减  4 优惠券  5满赠  6包邮)
    private Integer promoteType;

    @FormFieldAnnotation(title = "活动说明", sortNum = "4", grid = true, col = ColType.col_2)
    private String note;

    //活动条件-商品数量
    private Integer productNum;

    //活动条件-订单金额
    private Integer orderAmount;

    //活动条件-类型(1 满多少 2 每满多少 3第几件)
    private Integer conType;

    private Integer discountAmount;

    //活动优惠类型(1订单满减 2订单赠品 3订单赠优惠券 4包邮 5支付减 6单品优惠 7订单使用优惠券)
    private Integer discountMode;

    //活动范围(1全部商品 2部分类目 3部分商品  4排除部分商品)
    private Integer promoteScope;

    //活动图标
    private String logo;

    private Integer enableState;

    private Integer platformPromote;

    private StoreState storeState;

    @FormFieldAnnotation(title = "起订量", sortNum = "1", grid = true, col = ColType.col_2)
    private Integer mini;

    @FormFieldAnnotation(title = "步长", sortNum = "1", grid = true, col = ColType.col_2)
    private Integer step;

    @FormFieldAnnotation(title = "付款比例", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal scale;


    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinTable(name = "bs_tenant_promote_scope_category",
            joinColumns = {@JoinColumn(name = "promote_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<ProductCatalog> categories;

    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinTable(
            name = "bs_tenant_promote_give_product",
            joinColumns = {@JoinColumn(name = "promote_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    public List<Product> products;

    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinTable(
            name = "bs_tenant_promote_exclude_product",
            joinColumns = {@JoinColumn(name = "promote_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    public List<Product> excludeProducts;

}
