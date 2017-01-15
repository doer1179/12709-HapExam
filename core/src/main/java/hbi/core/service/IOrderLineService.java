package hbi.core.service;

import com.hand.hap.system.service.IBaseService;
import hbi.core.dto.OrderHeader;
import hbi.core.dto.OrderLine;

import java.util.List;

/**
 * Created by Yc on 2017/1/14.
 */
public interface IOrderLineService extends IBaseService<OrderLine> {
    List<OrderLine> selectByHeaderId(Integer headerId);
    int insertLine(OrderLine orderLine);

    int updateLine(OrderLine orderLine);

    int deleteLineByLineId(Integer id);

    int deleteLineByHeaderId(Integer id);

}
