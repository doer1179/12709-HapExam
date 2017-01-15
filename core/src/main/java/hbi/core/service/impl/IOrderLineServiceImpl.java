package hbi.core.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.dto.OrderHeader;
import hbi.core.dto.OrderLine;
import hbi.core.mapper.OrderHeaderMapper;
import hbi.core.mapper.OrderLineMapper;
import hbi.core.service.IOrderHeaderService;
import hbi.core.service.IOrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yc on 2017/1/12.
 */
@Service
public class IOrderLineServiceImpl extends BaseServiceImpl<OrderLine> implements IOrderLineService {

    @Autowired
    OrderLineMapper orderLineMapper;
    @Override
    public List<OrderLine> selectByHeaderId(Integer headerId) {
        return orderLineMapper.selectByHeaderId(headerId);
    }

    @Override
    public int insertLine(OrderLine orderLine) {
        return orderLineMapper.insertLine(orderLine);
    }

    @Override
    public int updateLine(OrderLine orderLine) {
        return orderLineMapper.updateLine(orderLine);
    }

    @Override
    public int deleteLineByLineId(Integer id) {
        return orderLineMapper.deleteLineByLineId(id);
    }

    @Override
    public int deleteLineByHeaderId(Integer id) {
        return orderLineMapper.deleteLineByHeaderId(id);
    }


}
