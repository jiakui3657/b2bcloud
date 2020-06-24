package com.haoxuer.b2bcloud.finance.api.domain.response;

import com.haoxuer.b2bcloud.finance.api.domain.simple.TradeAccountSimple;
import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FinanceAccountsResponse extends ResponseObject {

    //余额
    private TradeAccountSimple account;

    //积分
    private TradeAccountSimple score;

    /**
     * 费用包
     */
    private TradeAccountSimple fee;

    /**
     * 返利账户
     */
    private TradeAccountSimple rebate;

    //信用额度
    private BigDecimal credit;


}
