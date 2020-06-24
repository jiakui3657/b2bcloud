package com.haoxuer.b2bcloud.finance.rest.conver;

import com.haoxuer.b2bcloud.finance.api.domain.simple.FinanceAccountSimple;
import com.haoxuer.b2bcloud.finance.data.entity.FinanceAccount;
import com.haoxuer.discover.data.rest.core.Conver;

import java.math.BigDecimal;

public class FinanceFeeSimpleConver implements Conver<FinanceAccountSimple, FinanceAccount> {
    @Override
    public FinanceAccountSimple conver(FinanceAccount source) {
        FinanceAccountSimple result = new FinanceAccountSimple();
        result.setId(source.getId());
        result.setCredit(source.getCredit());
        result.setName(source.getName());
        result.setNo(source.getNo());
        result.setPhone(source.getPhone());
        result.setShop(source.getShop());
        if (source.getFee() != null) {
            result.setAccount(source.getFee().getAmount());
        }
        if (result.getAccount() == null) {
            result.setAccount(new BigDecimal(0));
        }
        if (result.getCredit() == null) {
            result.setCredit(new BigDecimal(0));
        }
        return result;
    }
}
