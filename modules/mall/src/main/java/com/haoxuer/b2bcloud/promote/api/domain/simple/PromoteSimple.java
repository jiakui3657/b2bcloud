package com.haoxuer.b2bcloud.promote.api.domain.simple;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Created by imake on 2020年05月11日14:18:16.
 */

@Data
public class PromoteSimple implements Serializable {

    private Long id;

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

    private String beginDate;

    private String endDate;

}