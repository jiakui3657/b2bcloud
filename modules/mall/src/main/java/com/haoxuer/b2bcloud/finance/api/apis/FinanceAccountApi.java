package com.haoxuer.b2bcloud.finance.api.apis;

import com.haoxuer.b2bcloud.finance.api.domain.page.FinanceAccountPage;
import com.haoxuer.b2bcloud.finance.api.domain.request.FinanceAccountSearchRequest;
import com.haoxuer.b2bcloud.finance.api.domain.request.MoneyRequest;
import com.haoxuer.b2bcloud.finance.api.domain.request.UpdateCreditRequest;
import com.haoxuer.b2bcloud.finance.api.domain.response.CreditResponse;
import com.haoxuer.b2bcloud.finance.api.domain.response.FinanceAccountsResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.pay.api.domain.page.TradeStreamPage;
import com.haoxuer.bigworld.pay.api.domain.request.CashStreamRequest;
import com.haoxuer.discover.rest.base.ResponseObject;

public interface FinanceAccountApi {

    /**
     * 账号明细
     *
     * @param request
     * @return
     */
    FinanceAccountPage search(FinanceAccountSearchRequest request);

    /**
     * 更新信用额度
     *
     * @param request
     * @return
     */
    CreditResponse updateCredit(UpdateCreditRequest request);

    /**
     * 扣除余额
     *
     * @param request
     * @return
     */
    ResponseObject deduct(MoneyRequest request);


    /**
     * 增加余额
     *
     * @param request
     * @return
     */
    ResponseObject add(MoneyRequest request);

    /**
     * 积分账号
     *
     * @param request
     * @return
     */
    FinanceAccountPage score(FinanceAccountSearchRequest request);

    /**
     * 积分减少
     *
     * @param request
     * @return
     */
    ResponseObject deductScore(MoneyRequest request);

    /**
     * 积分增加
     *
     * @param request
     * @return
     */
    ResponseObject addScore(MoneyRequest request);


    /**
     * 获取某个账号的资金流水
     *
     * @param request
     * @return
     */
    TradeStreamPage stream(CashStreamRequest request);

    /**
     * 获取费用包
     *
     * @param request
     * @return
     */
    FinanceAccountPage fee(FinanceAccountSearchRequest request);

    /**
     * 减少费用包
     *
     * @param request
     * @return
     */
    ResponseObject deductFee(MoneyRequest request);

    /**
     * 增加费用包
     *
     * @param request
     * @return
     */
    ResponseObject addFee(MoneyRequest request);


    /**
     * 资金账号信息
     *
     * @param request
     * @return
     */
    FinanceAccountsResponse accounts(TenantRequest request);


}
