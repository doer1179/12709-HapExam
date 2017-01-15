package hbi.core.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.dto.OrderHeader;
import hbi.core.mapper.OrderHeaderMapper;
import hbi.core.service.IOrderHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yc on 2017/1/12.
 */
@Service
public class IOrderHeaderServiceImpl extends BaseServiceImpl<OrderHeader> implements IOrderHeaderService {

    @Autowired
    OrderHeaderMapper orderHeaderMapper;
    @Override
    public List<OrderHeader>  selectOrderHeader (OrderHeader orderHeader) {
        return orderHeaderMapper.selectOrderHeader(orderHeader);
    }

    @Override
    public List<OrderHeader> selectByHeaderId(Integer headerId) {
        return  orderHeaderMapper.selectByHeaderId(headerId);
    }

    @Override
    public int addHeader(OrderHeader orderHeader) {
        return orderHeaderMapper.insert(orderHeader);
    }

    @Override
    public int updateHeader(OrderHeader orderHeader) {
        return orderHeaderMapper.updateHeader(orderHeader);
    }

    @Override
    public int deleteById(Integer headerId) {
        return orderHeaderMapper.deleteById(headerId);
    }
}
