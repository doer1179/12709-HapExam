package hbi.core.service;

import com.hand.hap.system.service.IBaseService;
import hbi.core.dto.OrderHeader;
import hbi.core.mapper.OrderHeaderMapper;

import java.util.List;

/**
 * Created by Yc on 2017/1/12.
 */
public  interface IOrderHeaderService extends IBaseService<OrderHeader> {

    List<OrderHeader> selectOrderHeader (OrderHeader orderHeader);
    List<OrderHeader> selectByHeaderId(Integer headerId);
    int addHeader(OrderHeader orderHeader);
    int updateHeader(OrderHeader orderHeader);
    int deleteById(Integer headerId);
}
