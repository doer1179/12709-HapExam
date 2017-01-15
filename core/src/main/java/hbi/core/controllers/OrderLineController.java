package hbi.core.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.dto.OrderHeader;
import hbi.core.dto.OrderLine;
import hbi.core.service.IOrderHeaderService;
import hbi.core.service.IOrderLineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yc on 2017/1/13.
 */
@RestController
public class OrderLineController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IOrderLineService orderLineService;

    @RequestMapping(value = "/lines/query/{headerId}")
    @ResponseBody
    public ResponseData findById(HttpServletRequest request, @PathVariable(value = "headerId") String headerId) {
        System.out.println(headerId);
        IRequest iRequest = createRequestContext(request);
        int id = 0;
        if (headerId != null && headerId != "")
            id = Integer.valueOf(headerId);
        List<OrderLine> linesList = orderLineService.selectByHeaderId(id);
        logger.info("afterQuery={}", linesList);
        return new ResponseData(linesList);
    }


    @RequestMapping(value = "/lines/addLines", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData insertLine(HttpServletRequest request, @RequestBody OrderLine orderLine) {
        IRequest iRequest = createRequestContext(request);
        int sumLines = orderLineService.insertLine(orderLine);
        ResponseData responseData = new ResponseData();
        if (sumLines > 0) {
            responseData.setMessage("新增成功");
            List<OrderLine> linesList = new ArrayList<>();
            linesList.add(orderLine);
            responseData.setSuccess(true);
            responseData.setRows(linesList);
            return responseData;
        } else {
            responseData.setMessage("新增失败");
            responseData.setSuccess(false);
            return responseData;
        }
    }


    @RequestMapping(value = "/lines/updateLines", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData updateLine(HttpServletRequest request, @RequestBody OrderLine orderLine) {
        IRequest iRequest = createRequestContext(request);
        int sumLines = orderLineService.updateLine(orderLine);
        if (sumLines > 0) {
            return new ResponseData(true);
        } else {
            return new ResponseData(false);
        }
    }


    @RequestMapping(value = "/lines/deleteLines", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseData deleteLine(HttpServletRequest request, @RequestBody List<OrderLine> orderLine) {
        IRequest iRequest = createRequestContext(request);
        orderLineService.batchDelete(orderLine);
        return new ResponseData(orderLine);
    }

}

