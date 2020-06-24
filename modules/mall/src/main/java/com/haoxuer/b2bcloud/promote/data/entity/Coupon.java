package com.haoxuer.b2bcloud.promote.data.entity;

import com.haoxuer.b2bcloud.product.data.entity.ProductCatalog;
import com.haoxuer.b2bcloud.promote.data.enums.CouponType;
import com.haoxuer.b2bcloud.store.data.entity.Store;
import com.haoxuer.bigworld.member.data.entity.TenantUserEntity;
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
@FormAnnotation(title = "优惠券", add = "优惠券", list = "优惠券", update = "优惠券")
@Entity
@Table(name = "bs_tenant_promote_coupon")
public class Coupon extends TenantUserEntity {



    //优惠券类型(1 活动优惠券 2 普通优惠券 活动优惠券则费用由卖家承担，普通优惠券谁发行谁承担)
    private CouponType couponType;

    private Short expireType;

    @FormFieldAnnotation(title = "订单金额", sortNum = "5", grid = true, col = ColType.col_2)
    private BigDecimal orderAmount;


    //使用条件-订单金额
    @FormFieldAnnotation(title = "优惠卷金额", sortNum = "6", grid = true, col = ColType.col_2)
    private BigDecimal discountAmount;


    //发放形式(1用户领取 2满赠 3其他方式赠送)
    private Short getMode;

    //每账户领取数量
    private Short getNum;
    private Boolean isPlatformCoupon;

    //发放数量(0无限制)
    private Integer issueNum;

    @FormFieldAnnotation(title = "名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String name;

    @FormFieldAnnotation(title = "优惠券开始时间", sortNum = "2",type = InputType.date,grid = true, col = ColType.col_2)
    private Date useBeginTime;

    @FormFieldAnnotation(title = "优惠券截止时间", sortNum = "3",type = InputType.date, grid = true, col = ColType.col_2)
    private Date useEndTime;

    @FormFieldAnnotation(title = "固定天数", sortNum = "4", grid = false, col = ColType.col_2)
    private Integer useDay;


    /**
     * 活动范围(1全部商品 3部分类目)
     */
    @FormFieldAnnotation(title = "活动范围", sortNum = "1", grid = false, col = ColType.col_2)
    private Short couponScope;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    private Promote promote;

    @ManyToMany(cascade = {CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(name = "bs_tenant_promote_coupon_scope",
            joinColumns = {@JoinColumn(name = "coupon_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<ProductCatalog> categories;

    private StoreState storeState;

}
