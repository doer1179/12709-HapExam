package hbi.core.controllers;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.dto.OrderHeader;
import hbi.core.service.IOrderHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yc on 2017/1/13.
 */
@RestController
@RequestMapping(value = "/orderHeaderController")
public class OrderHeaderController extends BaseController {
    @Autowired
    IOrderHeaderService orderHeaderService;
@RequestMapping(method = RequestMethod.GET)
    public ResponseData selectOrderHeader(HttpServletRequest request, OrderHeader orderHeader,
                                          @RequestParam(name ="page", required = false, defaultValue = "1") int page,
                                          @RequestParam(name ="pageSize", required = false, defaultValue = "10") int pageSize){

        IRequest requestContext = this.createRequestContext(request);
        PageHelper.startPage(page,pageSize);
        return new ResponseData(orderHeaderService.selectOrderHeader(orderHeader));
    }
    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    public ResponseData selectByHeaderId(HttpServletRequest request,
                                         @RequestParam(name ="headerId", required = false, defaultValue = "1") Integer headerId){

        IRequest requestContext = this.createRequestContext(request);
        return new ResponseData(orderHeaderService.selectByHeaderId(headerId));

    }

    @RequestMapping( method = RequestMethod.PUT)
    @ResponseBody
    public ResponseData addHeaders(HttpServletRequest request, @RequestBody OrderHeader headers) throws ParseException {
        IRequest iRequest = createRequestContext(request);
        int sumHeaders=orderHeaderService.addHeader(headers);
        ResponseData responseData = new ResponseData();
        if (sumHeaders>0){
            responseData.setMessage("新增成功");
            List<OrderHeader> headersList = new ArrayList<>();
            headersList.add(headers);
            responseData.setSuccess(true);
            responseData.setRows(headersList);
            return responseData;
        }else {
            responseData.setMessage("新增失败");
            responseData.setSuccess(false);
            return responseData;
        }
    }



    /**
     * 更新数据(状态)
     * @param request 请求方式POST
     * @param headers Headers
     * @return 1:更新成功,0:更新失败
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData updateHeader(HttpServletRequest request, @RequestBody OrderHeader headers) throws ParseException {
        IRequest iRequest = createRequestContext(request);
        int sum = orderHeaderService.updateHeader(headers);
        OrderHeader headersUpdated = orderHeaderService.selectByPrimaryKey(iRequest,headers);
        List<OrderHeader> headersList =new ArrayList<>();
        headersList.add(headersUpdated);
        return new ResponseData(headersList);
    }


    /**
     * 整单删除
     * @param request DELETE
     * @param headerId headerId
     * @return true false
     */
    @RequestMapping(value = "/delete/{headerId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseData deleteHeader(HttpServletRequest request, @PathVariable Integer headerId) {
        IRequest iRequest = createRequestContext(request);
        orderHeaderService.deleteById(headerId);
        return new ResponseData(true);
    }


}
