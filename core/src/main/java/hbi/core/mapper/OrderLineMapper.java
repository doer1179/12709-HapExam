package hbi.core.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.dto.OrderLine;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yc on 2017/1/14.
 */

public interface OrderLineMapper extends Mapper<OrderLine> {

    //通过headerId查找数据
    List<OrderLine> selectByHeaderId(Integer headerId);

    int insertLine(OrderLine orderLine);

    int updateLine(OrderLine orderLine);

    int deleteLineByLineId(Integer lineId);

    int deleteLineByHeaderId(Integer headerId);

}
