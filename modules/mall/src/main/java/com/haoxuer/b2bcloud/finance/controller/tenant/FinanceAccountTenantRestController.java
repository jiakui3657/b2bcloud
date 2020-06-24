package com.haoxuer.b2bcloud.finance.controller.tenant;

import com.haoxuer.b2bcloud.finance.api.apis.FinanceAccountApi;
import com.haoxuer.b2bcloud.finance.api.domain.page.FinanceAccountPage;
import com.haoxuer.b2bcloud.finance.api.domain.request.FinanceAccountSearchRequest;
import com.haoxuer.b2bcloud.finance.api.domain.request.MoneyRequest;
import com.haoxuer.b2bcloud.finance.api.domain.request.UpdateCreditRequest;
import com.haoxuer.b2bcloud.finance.api.domain.response.CreditResponse;
import com.haoxuer.b2bcloud.finance.api.domain.response.FinanceAccountsResponse;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.member.controller.rest.BaseRestController;
import com.haoxuer.bigworld.member.controller.tenant.BaseTenantRestController;
import com.haoxuer.bigworld.pay.api.domain.page.TradeStreamPage;
import com.haoxuer.bigworld.pay.api.domain.request.CashStreamRequest;
import com.haoxuer.discover.rest.base.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinanceAccountTenantRestController extends BaseTenantRestController {


    @RequestMapping("/tenantRest/financeAccount/search")
    public FinanceAccountPage search(FinanceAccountSearchRequest request) {
        initTenant(request);
        return api.search(request);
    }

    @RequestMapping("/tenantRest/financeAccount/updateCredit")
    public CreditResponse updateCredit(UpdateCreditRequest request) {
        initTenant(request);
        return api.updateCredit(request);
    }

    @RequestMapping("/tenantRest/financeAccount/deduct")
    public ResponseObject deduct(MoneyRequest request) {
        initTenant(request);
        return api.deduct(request);
    }

    @RequestMapping("/tenantRest/financeAccount/add")
    public ResponseObject add(MoneyRequest request) {
        initTenant(request);
        return api.add(request);
    }

    @RequestMapping("/tenantRest/financeAccount/score")
    public FinanceAccountPage score(FinanceAccountSearchRequest request) {
        initTenant(request);
        return api.score(request);
    }

    @RequestMapping("/tenantRest/financeAccount/deductScore")
    public ResponseObject deductScore(MoneyRequest request) {
        initTenant(request);
        return api.deductScore(request);
    }

    @RequestMapping("/tenantRest/financeAccount/addScore")
    public ResponseObject addScore(MoneyRequest request) {
        initTenant(request);
        return api.addScore(request);
    }

    @RequestMapping("/tenantRest/financeAccount/stream")
    public TradeStreamPage stream(CashStreamRequest request) {
        initTenant(request);
        return api.stream(request);
    }

    @RequestMapping("/tenantRest/financeAccount/fee")
    public FinanceAccountPage fee(FinanceAccountSearchRequest request) {
        initTenant(request);
        return api.fee(request);
    }

    @RequestMapping("/tenantRest/financeAccount/deductFee")
    public ResponseObject deductFee(MoneyRequest request) {
        initTenant(request);
        return api.deductFee(request);
    }

    @RequestMapping("/tenantRest/financeAccount/addFee")
    public ResponseObject addFee(MoneyRequest request) {
        initTenant(request);
        return api.addFee(request);
    }

    @RequestMapping("/tenantRest/financeAccount/accounts")
    public FinanceAccountsResponse accounts(TenantRequest request) {
        initTenant(request);
        return api.accounts(request);
    }

    @Autowired
    private FinanceAccountApi api;

}
