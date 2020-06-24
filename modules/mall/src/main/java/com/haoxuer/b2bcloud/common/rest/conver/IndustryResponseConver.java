package com.haoxuer.b2bcloud.common.rest.conver;

import com.haoxuer.b2bcloud.common.api.domain.response.IndustryResponse;
import com.haoxuer.b2bcloud.common.data.entity.Industry;
import com.haoxuer.discover.data.rest.core.Conver;

public class IndustryResponseConver implements Conver<IndustryResponse, Industry> {
    @Override
    public IndustryResponse conver(Industry source) {
        IndustryResponse result = new IndustryResponse();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
