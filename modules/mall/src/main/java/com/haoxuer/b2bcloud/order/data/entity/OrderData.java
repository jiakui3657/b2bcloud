package com.haoxuer.b2bcloud.order.data.entity;

import com.haoxuer.b2bcloud.store.data.entity.Store;
import com.haoxuer.bigworld.member.data.entity.TenantUser;
import com.haoxuer.bigworld.pay.data.enums.PayState;
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


@Data
@FormAnnotation(title = "商品信息", add = "商品信息", list = "商品信息", update = "商品信息")
@Entity
@Table(name = "bs_tenant_order_info")
public class OrderData extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private TenantUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @Column(length = 50)
    @FormFieldAnnotation(title = "订单号", sortNum = "1", grid = true, col = ColType.col_2)
    private String no;

    //合并支付订单号（未拆单情况下与订单号一致;已拆单情况下，与订单号不一致，但多笔子订单的合并支付订单号是一致）
    @FormFieldAnnotation(title = "合并支付订单号", sortNum = "1", grid = false, col = ColType.col_2)
    private String mergeOrderCode;

    @FormFieldAnnotation(title = "外部交易流水号", sortNum = "1", grid = true, col = ColType.col_2)
    private String outTradeNum;

    //订单来源 1pc  2 移动端h5 3APP  4 微信客户端H5  5小程序（微信小程序）
    @FormFieldAnnotation(title = "订单来源", sortNum = "1", grid = true, col = ColType.col_2)
    private Integer orderSource;

    //支付来源 1pc  2 移动端h5 3APP  4 微信客户端H5  5小程序（微信小程序）
    @FormFieldAnnotation(title = "支付来源", sortNum = "1", grid = false, col = ColType.col_2)
    private Integer paySource;

    @FormFieldAnnotation(title = "最新售后ID", sortNum = "1", grid = false, col = ColType.col_2)
    private Long newRefundId;

    //订单状态(1待付款 2待发货 3待收货 4已完成 5已取消 6超时交易关闭 )
    @FormFieldAnnotation(title = "订单状态", sortNum = "1", grid = true, col = ColType.col_2)
    private Integer state;

    //评价状态 1-待评价  2-已评价  3-对方已评  4-双方已评
    @FormFieldAnnotation(title = "评价状态", sortNum = "1", grid = false, col = ColType.col_2)
    private Integer commentState;

    //用户删除(0未删除 1回收站 2删除)
    @FormFieldAnnotation(title = "用户删除", sortNum = "1", grid = false, col = ColType.col_2)
    private Integer userState;

    //支付方式( 1支付宝 2微信  3银联 4余额 5现金)
    @FormFieldAnnotation(title = "支付方式", sortNum = "1", grid = false, col = ColType.col_2)
    private Integer payMode;

    @FormFieldAnnotation(title = "下单时间", sortNum = "1", grid = false, col = ColType.col_2)
    private Date orderTime;

    @FormFieldAnnotation(title = "支付时间", sortNum = "1", grid = false, col = ColType.col_2)
    private Date payTime;

    @FormFieldAnnotation(title = "发货时间", sortNum = "1", grid = false, col = ColType.col_2)
    private Date deliveryTime;

    @FormFieldAnnotation(title = "收货时间", sortNum = "1", grid = false, col = ColType.col_2)
    private Date receiveTime;

    //订单类型(1实物订单 2虚拟订单)
    @FormFieldAnnotation(title = "订单类型", sortNum = "1", grid = false, col = ColType.col_2)
    private Integer orderType;

    @FormFieldAnnotation(title = "重量", sortNum = "1", grid = false, col = ColType.col_2)
    private BigDecimal weight;


    @FormFieldAnnotation(title = "原价", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal totalAmount;

    //订单优惠后总金额（不含运费）
    @FormFieldAnnotation(title = "订单优惠后总金额", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal productAmount;

    //订单优惠后总金额(含运费)
    @FormFieldAnnotation(title = "订单优惠后总金额", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal amount;

    //实际支付金额(抵扣红包、积分金额)
    @FormFieldAnnotation(title = "实际支付金额", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal payAmount;

    @FormFieldAnnotation(title = "运费", sortNum = "1", grid = false, col = ColType.col_2)
    private BigDecimal freight;

    @FormFieldAnnotation(title = "卖家优惠总金额", sortNum = "1", grid = false, col = ColType.col_2)
    private BigDecimal discount;

    @FormFieldAnnotation(title = "平台优惠优惠券金额", sortNum = "1", grid = false, col = ColType.col_2)
    private BigDecimal platformDiscount;

    @FormFieldAnnotation(title = "积分抵扣", sortNum = "1", grid = false, col = ColType.col_2)
    private BigDecimal integralDiscount;

    @FormFieldAnnotation(title = "使用积分数", sortNum = "1", grid = false, col = ColType.col_2)
    private BigDecimal useIntegral;

    @FormFieldAnnotation(title = "使用红包", sortNum = "1", grid = false, col = ColType.col_2)
    private BigDecimal useRedPacket;

    @FormFieldAnnotation(title = "单件商品红包抵扣", sortNum = "1", grid = false, col = ColType.col_2)
    private BigDecimal redPacketDiscount;

    @FormFieldAnnotation(title = "退款金额", sortNum = "1", grid = false, col = ColType.col_2)
    private BigDecimal returnAmount;

    @FormFieldAnnotation(title = "积分赠送", sortNum = "1", grid = false, col = ColType.col_2)
    private BigDecimal sendIntegral;

    @FormFieldAnnotation(title = "系统自动收货时间", sortNum = "1", grid = false, col = ColType.col_2)
    private Date sysReceiveTime;

    @FormFieldAnnotation(title = "是否已延长收货", sortNum = "1", grid = false, col = ColType.col_2)
    private boolean hasExtendReceive;

    @FormFieldAnnotation(title = "商家改价格时间", sortNum = "1", grid = false, col = ColType.col_2)
    private Date editPriceTime;

    @FormFieldAnnotation(title = "完成时间", sortNum = "1", grid = false, col = ColType.col_2)
    private Date finishTime;

    @FormFieldAnnotation(title = "购买数量", sortNum = "1", grid = false, col = ColType.col_2)
    private Integer productCount;

    @FormFieldAnnotation(title = "退货数量", sortNum = "1", grid = false, col = ColType.col_2)
    private Integer returnCount;

    @FormFieldAnnotation(title = "最后提现时间", sortNum = "1", grid = false, col = ColType.col_2)
    private Date remindTime;

    private StoreState storeState;

    @OneToMany(mappedBy = "orderData",fetch = FetchType.LAZY)
    private List<OrderItem> items;



    @Column(length = 20)
    @FormFieldAnnotation(title = "联系电话", sortNum = "1", grid = true, col = ColType.col_2)
    private String phone;

    @Column(length = 100)
    @FormFieldAnnotation(title = "收货地址", sortNum = "1", grid = true, col = ColType.col_2)
    private String address;

    @Column(length = 500)
    @FormFieldAnnotation(title = "备注", sortNum = "1", grid = true, col = ColType.col_2)
    private String note;

    @Column(length = 20)
    @FormFieldAnnotation(title = "收货人", sortNum = "1", grid = true, col = ColType.col_2)
    private String consignee;

    private PayState payState;

}
