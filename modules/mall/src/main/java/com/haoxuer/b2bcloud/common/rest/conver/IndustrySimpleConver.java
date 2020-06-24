package com.haoxuer.b2bcloud.common.rest.conver;

import com.haoxuer.b2bcloud.common.api.domain.simple.IndustrySimple;
import com.haoxuer.b2bcloud.common.data.entity.Industry;
import com.haoxuer.discover.data.rest.core.Conver;

public class IndustrySimpleConver implements Conver<IndustrySimple, Industry> {
    @Override
    public IndustrySimple conver(Industry source) {
        IndustrySimple result = new IndustrySimple();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
