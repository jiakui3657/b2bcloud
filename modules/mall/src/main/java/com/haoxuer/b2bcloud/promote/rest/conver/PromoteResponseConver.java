package com.haoxuer.b2bcloud.promote.rest.conver;

import com.haoxuer.b2bcloud.promote.api.domain.response.PromoteResponse;
import com.haoxuer.b2bcloud.promote.data.entity.Promote;
import com.haoxuer.discover.data.rest.core.Conver;

public class PromoteResponseConver implements Conver<PromoteResponse, Promote> {
    @Override
    public PromoteResponse conver(Promote source) {
        PromoteResponse result = new PromoteResponse();
        result.setId(source.getId());
        result.setEnableState(source.getEnableState());
        result.setNote(source.getNote());
        result.setPlatformPromote(source.getPlatformPromote());
        result.setMini(source.getMini());
        result.setDiscountAmount(source.getDiscountAmount());
        result.setPromoteScope(source.getPromoteScope());
        result.setProductNum(source.getProductNum());
        result.setOrderAmount(source.getOrderAmount());
        result.setPromoteType(source.getPromoteType());
        result.setConType(source.getConType());
        result.setLogo(source.getLogo());
        result.setName(source.getName());
        result.setDiscountMode(source.getDiscountMode());
        result.setStep(source.getStep());
        return result;
    }
}
