package com.haoxuer.b2bcloud.analysis.resource;

import com.haoxuer.b2bcloud.analysis.api.OrderAnalysisApi;
import com.haoxuer.b2bcloud.analysis.mapper.OrderMapper;
import com.haoxuer.b2bcloud.analysis.request.OrderNumRequest;
import com.haoxuer.bigworld.analysis.list.LongList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class OrderAnalysisResource implements OrderAnalysisApi {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public LongList num(OrderNumRequest request) {
        LongList result = new LongList();
        result.setList(orderMapper.num(request));
        if (result.getList() != null) {
            Long total = result.getList().stream().mapToLong(item -> item.getNum()).sum();
            result.setTotal(total);
        } else {
            result.setTotal(0L);
        }
        result.setName("订单数量");
        return result;
    }

    @Override
    public LongList month(OrderNumRequest request) {
        LongList result = new LongList();
        result.setList(orderMapper.month(request));
        if (result.getList() != null) {
            Long total = result.getList().stream().mapToLong(item -> item.getNum()).sum();
            result.setTotal(total);
        } else {
            result.setTotal(0L);
        }
        result.setName("订单数量");
        return result;
    }
}
