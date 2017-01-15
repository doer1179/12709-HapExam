package hbi.core.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.dto.OrderHeader;

import java.util.List;

/**
 * Created by Yc on 2017/1/12.
 */
public interface OrderHeaderMapper extends Mapper<OrderHeader> {

    List<OrderHeader> selectOrderHeader (OrderHeader orderHeader);
    List<OrderHeader> selectByHeaderId(Integer headerId);
    int updateHeader(OrderHeader orderHeader);
    int deleteById(Integer headerId);
}
