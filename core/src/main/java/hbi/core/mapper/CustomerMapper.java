package hbi.core.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.dto.Customer;

import java.util.List;

/**
 * Created by Yc on 2017/1/13.
 */
public interface CustomerMapper extends Mapper<Customer> {
    List<Customer> selectAll();
}
