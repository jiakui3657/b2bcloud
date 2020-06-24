package com.haoxuer.meicloud.wms.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 货物
 */
@Data
@FormAnnotation(title = "物品", add = "添加物品", list = "物品列表", update = "更新物品")
@Entity
@Table(name = "bs_tenant_wms_warehouse_good")
public class Good extends TenantEntity {

    /**
     * 货物名称
     */
    @Column(length = 30)
    private String name;

    /**
     * 货物sn(69码)
     */
    @Column(length = 30)
    private String sn;

    /**
     * 货物自有编码
     */
    @Column(length = 30)
    private String code;

    private String logo;

    private String note;

    private BigDecimal money;


    @Column(length = 20)
    private String pyHeader;
}
