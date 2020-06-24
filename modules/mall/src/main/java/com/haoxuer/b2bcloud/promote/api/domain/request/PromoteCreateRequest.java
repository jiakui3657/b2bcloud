package com.haoxuer.b2bcloud.promote.api.domain.request;


import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.annotations.InputType;
import lombok.Data;

import java.util.Date;

/**
*
* Created by imake on 2020年05月11日14:18:16.
*/

@Data
public class PromoteCreateRequest extends TenantRequest {


     private Integer enableState;

     private String note;

     private Integer platformPromote;

     private Integer mini;

     private Integer discountAmount;

     private Integer promoteScope;

     private Integer productNum;

     private Integer orderAmount;

     private Integer promoteType;

     private Integer conType;

     private String logo;

     private String name;

     private Integer discountMode;

     private Integer step;

     private Date beginDate;

     private Date endDate;

}