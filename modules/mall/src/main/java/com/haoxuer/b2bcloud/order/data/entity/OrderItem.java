package com.haoxuer.b2bcloud.order.data.entity;

import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.b2bcloud.product.data.entity.ProductSku;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@FormAnnotation(title = "商品信息", add = "商品信息", list = "商品信息", update = "商品信息")
@Entity
@Table(name = "bs_tenant_order_item")
public class OrderItem extends TenantEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderData orderData;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductSku sku;

    @FormFieldAnnotation(title = "购买数量", sortNum = "1", grid = true, col = ColType.col_2)
    private Integer size;

    @FormFieldAnnotation(title = "退货数量", sortNum = "1", grid = true, col = ColType.col_2)
    private Integer returnNum;

    //使用数量
    private Integer useNum;

    //剩余
    private Integer surplusNum;

    @FormFieldAnnotation(title = "退款金额", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal returnAmount;

    //售后状态 0无 1部分退款 2全部退款 3部分换货 4全部换货 5部分退货退款 6全部退货退款 7综合售后
    @FormFieldAnnotation(title = "售后状态", sortNum = "1", grid = true, col = ColType.col_2)
    private Integer refundState;

    @FormFieldAnnotation(title = "单位", sortNum = "1", grid = true, col = ColType.col_2)
    private String unit;

    @FormFieldAnnotation(title = "重量", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal weight;

    @FormFieldAnnotation(title = "单价", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal price;

    @FormFieldAnnotation(title = "成交单价", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal realPrice;

    @FormFieldAnnotation(title = "运费", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal freight;

    @FormFieldAnnotation(title = "优惠金额", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal discountAmount;

    @FormFieldAnnotation(title = "平台优惠", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal platformDiscount;

    @FormFieldAnnotation(title = "积分抵扣", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal integralDiscount;

    @FormFieldAnnotation(title = "使用积分", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal useIntegral;

    @FormFieldAnnotation(title = "使用红包", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal useRedPacket;

    @FormFieldAnnotation(title = "单件商品红包抵扣", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal redPacketDiscount;

    //商品小计实际成交金额(扣除优惠分摊后的价格)不含运费
    @FormFieldAnnotation(title = "实际成交金额", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal realAmount;

    //商品小计实际用户支付金额(成交金额-积分抵扣-红包抵扣)不含运费
    @FormFieldAnnotation(title = "实际用户支付金额", sortNum = "1", grid = true, col = ColType.col_2)
    private BigDecimal payAmount;

    @FormFieldAnnotation(title = "是否是赠品", sortNum = "1", grid = true, col = ColType.col_2)
    private Boolean giveType;

    @FormFieldAnnotation(title = "商品sku", sortNum = "1", grid = true, col = ColType.col_2)
    private String skuAttr;

    @FormFieldAnnotation(title = "商品名称", sortNum = "1", grid = true, col = ColType.col_2)
    private String name;

    @FormFieldAnnotation(title = "商品封面", sortNum = "1", grid = true, col = ColType.col_2)
    private String logo;
}
