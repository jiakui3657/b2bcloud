package com.haoxuer.b2bcloud.finance.data.entity;


import com.haoxuer.bigworld.tenant.annotation.SearchItem;
import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "发票", add = "发票", list = "发票", update = "发票")
@Entity
@Table(name = "bs_tenant_finance_invoice")
public class Invoice extends TenantEntity {

    @SearchItem(name = "name",key = "name",label = "企业名称")
    @FormFieldAnnotation(title = "企业名称", sortNum = "1",grid = true)
    private String name;

    @SearchItem(name = "taxNo",key = "taxNo",label = "企业税号")
    @FormFieldAnnotation(title = "企业税号", sortNum = "2",grid = true)
    private String taxNo;


    @FormFieldAnnotation(title = "企业地址", sortNum = "3",grid = true)
    private String address;

    @FormFieldAnnotation(title = "企业电话", sortNum = "4",grid = true)
    private String phone;

    @FormFieldAnnotation(title = "开户银行", sortNum = "5",grid = true)
    private String bankName;

    @FormFieldAnnotation(title = "银行账户", sortNum = "6",grid = true)
    private String bankNo;
}
