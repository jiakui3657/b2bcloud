package com.haoxuer.b2bcloud.finance.rest.conver;

import com.haoxuer.b2bcloud.finance.api.domain.simple.TradeAccountSimple;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.trade.data.entity.TradeAccount;

public class TradeAccountSimpleConver implements Conver<TradeAccountSimple, TradeAccount> {
    @Override
    public TradeAccountSimple conver(TradeAccount source) {
        TradeAccountSimple result = new TradeAccountSimple();
        result.setId(source.getId());
        result.setMoney(source.getAmount());
        return result;
    }
}
