package com.haoxuer.b2bcloud.order.payhandlers;

import com.haoxuer.b2bcloud.order.data.dao.OrderTradeDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderTrade;
import com.haoxuer.bigworld.pay.data.entity.Payment;
import com.haoxuer.bigworld.pay.data.enums.PayState;
import com.haoxuer.bigworld.pay.data.payhandlers.PayHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("orderTradePayHandler")
public class OrderTradePayHandler implements PayHandler {

    @Autowired
    private OrderTradeDao dataDao;

    @Override
    public void pay(Payment payment) {
        if (payment.getBussId() != null) {
            OrderTrade data = dataDao.findById(payment.getBussId());
            if (data != null) {
                data.setPayState(PayState.success);
            }
        }
    }
}
