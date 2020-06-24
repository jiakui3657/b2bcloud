package com.haoxuer.b2bcloud.promote.rest.conver;

import com.haoxuer.b2bcloud.promote.api.domain.simple.PromoteSimple;
import com.haoxuer.b2bcloud.promote.data.entity.Promote;
import com.haoxuer.bigworld.member.utils.DateUtils;
import com.haoxuer.discover.data.rest.core.Conver;

public class PromoteSimpleConver implements Conver<PromoteSimple, Promote> {
    @Override
    public PromoteSimple conver(Promote source) {
        PromoteSimple result = new PromoteSimple();
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
        if (source.getBeginDate() != null) {
            result.setBeginDate(DateUtils.simple(source.getBeginDate()));
        } else {
            result.setBeginDate("");
        }
        if (source.getEndDate() != null) {
            result.setEndDate(DateUtils.simple(source.getEndDate()));
        } else {
            result.setEndDate("");
        }
        return result;
    }
}
