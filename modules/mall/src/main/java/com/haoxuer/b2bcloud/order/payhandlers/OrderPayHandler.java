package com.haoxuer.b2bcloud.order.payhandlers;

import com.haoxuer.b2bcloud.order.data.dao.OrderDataDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.bigworld.pay.data.entity.Payment;
import com.haoxuer.bigworld.pay.data.enums.PayState;
import com.haoxuer.bigworld.pay.data.payhandlers.PayHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("orderPayHandler")
public class OrderPayHandler implements PayHandler {

    @Autowired
    private OrderDataDao dataDao;

    @Override
    public void pay(Payment payment) {
        if (payment.getBussId() != null) {
            OrderData data = dataDao.findById(payment.getBussId());
            if (data != null) {
                data.setPayState(PayState.success);
            }
        }
    }
}
