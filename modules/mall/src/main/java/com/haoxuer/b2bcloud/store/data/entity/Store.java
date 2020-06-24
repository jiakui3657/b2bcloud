package com.haoxuer.b2bcloud.store.data.entity;

import com.haoxuer.b2bcloud.product.data.entity.ProductCatalog;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.trade.data.entity.TradeAccount;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@FormAnnotation(title = "门店", add = "门店", list = "门店", update = "门店")
@Entity
@Table(name = "bs_tenant_store_info")
public class Store extends TenantEntity {

    private String name;

    private Boolean isProductAuditEnable;
    private Boolean isWechatEnable;
    private String auditOpinion;
    private Short auditResults;
    private String contactMail;
    private String contactName;
    private String contactMobile;
    private Short status;
    private Boolean selfShop;
    private String storeName;
    private Short storeType;
    private String domainName;
    private String storeUsername;
    private Integer memberId;
    private Short freePayStatus;
    private Integer freePayType;
    private Integer saleCateId;
    private BigDecimal saleCateBond;
    private Integer levelId;
    private Integer logoId;
    private Short storeEntegerStatus;
    private Integer headImgId;




    @ManyToOne(fetch = FetchType.LAZY)
    private ProductCatalog productCatalog;


    @FormFieldAnnotation(title = "资金账号", sortNum = "1", grid = true, col = ColType.col_2)
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount account;

//    private StoreLevel storeLevel;
//    private StoreCustomerService customerService;
//    private StoreInfo storeInfo;
//    private StoreStatistics storeStatistic;
//
//    private ResourcesSpaceData storeLogoResource;
//    private ResourcesSpaceData storeHeadImgResource;
//
//    private List<StoreConsumeRecord> storeConsumeRecordList;
//    private List<DynamicRecord> dynamicRecordList;
//    private List<Brand> brands;
//    private List<OrderCommentH> commenthList;
//    private List<StoreSettlementAccount> storeSettlementAccountList;
//    private List<StoreUser> storeUserList;
//    private String memberUsername;
//    private String pStr;
//    private List<Product> productArray;
//    private Integer productNumber;
//    private Integer productSalesNumber;
}
