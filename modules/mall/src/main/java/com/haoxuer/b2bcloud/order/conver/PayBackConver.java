package com.haoxuer.b2bcloud.order.conver;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.pay.weixin.domain.PayBack;

public class PayBackConver implements Conver<PayBack, WxPayOrderNotifyResult> {
  @Override
  public PayBack conver(WxPayOrderNotifyResult source) {
    PayBack result=new PayBack();
    result.setAttach(source.getAttach());
    result.setBank_type(source.getBankType());
    result.setCash_fee(source.getCashFee());
    result.setCash_fee_type(source.getCashFeeType());
    result.setOut_trade_no(source.getOutTradeNo());
    result.setBank_type(source.getBankType());
    result.setIs_subscribe(source.getIsSubscribe());
    result.setFee_type(source.getFeeType());
    result.setReturn_msg(source.getReturnMsg());
    result.setResult_code(source.getResultCode());
    result.setReturn_code(source.getReturnCode());
    result.setTransaction_id(source.getTransactionId());
    result.setTrade_type(source.getTradeType());
    return result;
  }
}
