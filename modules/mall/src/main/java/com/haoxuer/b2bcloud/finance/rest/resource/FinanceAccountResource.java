package com.haoxuer.b2bcloud.finance.rest.resource;

import com.haoxuer.b2bcloud.finance.api.apis.FinanceAccountApi;
import com.haoxuer.b2bcloud.finance.api.domain.page.FinanceAccountPage;
import com.haoxuer.b2bcloud.finance.api.domain.request.FinanceAccountSearchRequest;
import com.haoxuer.b2bcloud.finance.api.domain.request.MoneyRequest;
import com.haoxuer.b2bcloud.finance.api.domain.request.UpdateCreditRequest;
import com.haoxuer.b2bcloud.finance.api.domain.response.CreditResponse;
import com.haoxuer.b2bcloud.finance.api.domain.response.FinanceAccountsResponse;
import com.haoxuer.b2bcloud.finance.api.domain.simple.TradeAccountSimple;
import com.haoxuer.b2bcloud.finance.data.dao.FinanceAccountDao;
import com.haoxuer.b2bcloud.finance.data.entity.FinanceAccount;
import com.haoxuer.b2bcloud.finance.rest.conver.FinanceAccountSimpleConver;
import com.haoxuer.b2bcloud.finance.rest.conver.FinanceFeeSimpleConver;
import com.haoxuer.b2bcloud.finance.rest.conver.FinanceScoreSimpleConver;
import com.haoxuer.b2bcloud.finance.rest.conver.TradeAccountSimpleConver;
import com.haoxuer.bigworld.member.api.domain.request.TenantRequest;
import com.haoxuer.bigworld.member.data.service.TenantTokenService;
import com.haoxuer.bigworld.member.rest.conver.PageableConver;
import com.haoxuer.bigworld.pay.api.domain.page.TradeStreamPage;
import com.haoxuer.bigworld.pay.api.domain.request.CashStreamRequest;
import com.haoxuer.bigworld.pay.rest.conver.TradeStreamSimpleConver;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import com.haoxuer.discover.rest.base.ResponseObject;
import com.haoxuer.discover.trade.data.dao.BasicTradeAccountDao;
import com.haoxuer.discover.trade.data.dao.TradeAccountDao;
import com.haoxuer.discover.trade.data.dao.TradeStreamDao;
import com.haoxuer.discover.trade.data.entity.TradeAccount;
import com.haoxuer.discover.trade.data.entity.TradeStream;
import com.haoxuer.discover.trade.data.others.ChangeType;
import com.haoxuer.discover.trade.data.request.TradeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Transactional
@Service
public class FinanceAccountResource implements FinanceAccountApi {

    @Autowired
    private FinanceAccountDao financeAccountDao;

    @Autowired
    private BasicTradeAccountDao basicTradeAccountDao;

    @Autowired
    private TradeAccountDao tradeAccountDao;

    @Autowired
    private TradeStreamDao streamDao;

    @Autowired
    private TenantTokenService tokenService;

    @Override
    public FinanceAccountPage search(FinanceAccountSearchRequest request) {
        FinanceAccountPage result = new FinanceAccountPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("dataType", 2000));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));

        Page<FinanceAccount> page = financeAccountDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new FinanceAccountSimpleConver());
        return result;
    }

    @Override
    public CreditResponse updateCredit(UpdateCreditRequest request) {
        CreditResponse result = new CreditResponse();
        FinanceAccount account = financeAccountDao.findById(request.getUser());
        if (account == null) {
            result.setCode(501);
            result.setMsg("无效用户id");
            return result;
        }
        if (request.getCredit() == null) {
            result.setCode(502);
            result.setMsg("无效信用额度");
            return result;
        }
        account.setCredit(request.getCredit());
        return result;
    }

    @Override
    public ResponseObject deduct(MoneyRequest request) {
        return handle(request, "deduct");
    }

    private ResponseObject handle(MoneyRequest request, String type) {
        ResponseObject result = new ResponseObject();
        FinanceAccount account = financeAccountDao.findById(request.getUser());
        if (account == null) {
            result.setCode(501);
            result.setMsg("无效用户id");
            return result;
        }
        if (account.getAccount() == null) {
            account.setAccount(tradeAccountDao.initSpecial());
        }
        if (request.getAccount() == null) {
            result.setCode(502);
            result.setMsg("无效金额");
            return result;
        }
        if (request.getAccount().compareTo(new BigDecimal(0)) < 0) {
            result.setCode(503);
            result.setMsg("无效金额");
            return result;
        }
        TradeAccount temp = account.getAccount();
        TradeAccount sys = basicTradeAccountDao.special("recharge");
        TradeRequest tradeRequest = new TradeRequest();

        tradeRequest.setAmount(request.getAccount());
        if ("deduct".equals(type)) {
            tradeRequest.setFrom(temp.getId());
            tradeRequest.setTo(sys.getId());
        } else {
            tradeRequest.setFrom(sys.getId());
            tradeRequest.setTo(temp.getId());
        }
        tradeRequest.setNote(request.getNote());
        tradeRequest.setChangeType(ChangeType.from(1, "充值"));
        tradeRequest.setNote(request.getNote());
        tradeAccountDao.trade(tradeRequest);
        return result;
    }

    @Override
    public ResponseObject add(MoneyRequest request) {
        return handle(request, "add");

    }

    private ResponseObject handleScore(MoneyRequest request, String type) {
        ResponseObject result = new ResponseObject();
        FinanceAccount account = financeAccountDao.findById(request.getUser());
        if (account == null) {
            result.setCode(501);
            result.setMsg("无效用户id");
            return result;
        }
        if (account.getScore() == null) {
            account.setScore(tradeAccountDao.initNormal());
        }
        if (request.getAccount() == null) {
            result.setCode(502);
            result.setMsg("无效金额");
            return result;
        }
        if (request.getAccount().compareTo(new BigDecimal(0)) < 0) {
            result.setCode(503);
            result.setMsg("无效金额");
            return result;
        }
        TradeAccount temp = account.getScore();
        TradeAccount sys = basicTradeAccountDao.special("score");
        TradeRequest tradeRequest = new TradeRequest();

        tradeRequest.setAmount(request.getAccount());
        if ("deduct".equals(type)) {
            tradeRequest.setFrom(temp.getId());
            tradeRequest.setTo(sys.getId());
        } else {
            tradeRequest.setFrom(sys.getId());
            tradeRequest.setTo(temp.getId());
        }
        tradeRequest.setNote(request.getNote());
        tradeRequest.setChangeType(ChangeType.from(1001, "积分交易"));
        tradeRequest.setNote(request.getNote());
        result = tradeAccountDao.trade(tradeRequest);
        return result;
    }

    @Override
    public FinanceAccountPage score(FinanceAccountSearchRequest request) {
        FinanceAccountPage result = new FinanceAccountPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("dataType", 2000));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));

        Page<FinanceAccount> page = financeAccountDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new FinanceScoreSimpleConver());
        return result;
    }

    @Override
    public ResponseObject deductScore(MoneyRequest request) {
        return handleScore(request, "deduct");

    }

    @Override
    public ResponseObject addScore(MoneyRequest request) {
        return handleScore(request, "add");
    }

    @Override
    public TradeStreamPage stream(CashStreamRequest request) {
        TradeStreamPage result = new TradeStreamPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getOrders().add(Order.desc("id"));
        Page<TradeStream> page = streamDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new TradeStreamSimpleConver());
        return result;
    }

    @Override
    public FinanceAccountPage fee(FinanceAccountSearchRequest request) {
        FinanceAccountPage result = new FinanceAccountPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        pageable.getFilters().add(Filter.eq("dataType", 2000));
        pageable.getFilters().add(Filter.eq("tenant.id", request.getTenant()));

        Page<FinanceAccount> page = financeAccountDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new FinanceFeeSimpleConver());
        return result;
    }

    @Override
    public ResponseObject deductFee(MoneyRequest request) {
        return handleFee(request, "deduct");
    }

    @Override
    public ResponseObject addFee(MoneyRequest request) {
        return handleFee(request, "add");
    }

    @Override
    public FinanceAccountsResponse accounts(TenantRequest request) {
        FinanceAccountsResponse result = new FinanceAccountsResponse();
        FinanceAccount account = financeAccountDao.findById(request.getUser());
        if (account == null) {
            result.setCode(501);
            result.setMsg("无效用户id");
            return result;
        }
        if (account.getFee() == null) {
            account.setFee(tradeAccountDao.initNormal());
        }
        if (account.getScore() == null) {
            account.setScore(tradeAccountDao.initNormal());
        }
        if (account.getRebate() == null) {
            account.setRebate(tradeAccountDao.initNormal());
        }
        if (account.getAccount() == null) {
            account.setAccount(tradeAccountDao.initNormal());
        }
        result.setCredit(account.getCredit());
        if (result.getCredit() == null) {
            result.setCredit(new BigDecimal(0));
        }
        TradeAccountSimple fee=new TradeAccountSimpleConver().conver(account.getFee());
        fee.setName("费用包");
        result.setFee(fee);

        TradeAccountSimple score=new TradeAccountSimpleConver().conver(account.getScore());
        score.setName("积分");
        result.setScore(score);

        TradeAccountSimple rebate=new TradeAccountSimpleConver().conver(account.getRebate());
        rebate.setName("返利");
        result.setRebate(rebate);

        TradeAccountSimple account1=new TradeAccountSimpleConver().conver(account.getAccount());
        account1.setName("余额");
        result.setAccount(account1);

        return result;
    }

    private ResponseObject handleFee(MoneyRequest request, String type) {
        ResponseObject result = new ResponseObject();
        FinanceAccount account = financeAccountDao.findById(request.getUser());
        if (account == null) {
            result.setCode(501);
            result.setMsg("无效用户id");
            return result;
        }
        if (account.getFee() == null) {
            account.setFee(tradeAccountDao.initNormal());
        }
        if (request.getAccount() == null) {
            result.setCode(502);
            result.setMsg("无效金额");
            return result;
        }
        if (request.getAccount().compareTo(new BigDecimal(0)) < 0) {
            result.setCode(503);
            result.setMsg("无效金额");
            return result;
        }
        TradeAccount temp = account.getFee();
        TradeAccount sys = basicTradeAccountDao.special("fee");
        TradeRequest tradeRequest = new TradeRequest();

        tradeRequest.setAmount(request.getAccount());
        if ("deduct".equals(type)) {
            tradeRequest.setFrom(temp.getId());
            tradeRequest.setTo(sys.getId());
        } else {
            tradeRequest.setFrom(sys.getId());
            tradeRequest.setTo(temp.getId());
        }
        tradeRequest.setNote(request.getNote());
        tradeRequest.setChangeType(ChangeType.from(1001, "费用包交易"));
        tradeRequest.setNote(request.getNote());
        result = tradeAccountDao.trade(tradeRequest);
        return result;
    }
}
