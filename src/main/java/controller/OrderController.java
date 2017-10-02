package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Order;
import po.PagedResult;
import po.Task;
import service.OrderService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> insert(@RequestBody Order order) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        int success = orderService.insertOrder(order);
        if (success == 1) {
            map.put("data", data);
            map.put("statusCode", "200");
            map.put("message", "订单成功");
            return map;
        } else {
            map.put("data", data);
            map.put("statusCode", "400");
            map.put("message", "订单失败");
            return map;
        }
    }

    @RequestMapping("/queryPublishedOrders")
    @ResponseBody
    public PagedResult<Order> queryPublishedOrders(@RequestBody Order order,
                                                   @RequestParam("pageNo") Integer pageNo,  @RequestParam("pageNo") Integer pageSize) {
        Integer receiverId = order.getReceiverId();
        Byte orderStatus = order.getOrderStatus();
        return orderService.getOrdersByReceiverId(receiverId, orderStatus, pageNo, pageSize);
    }

    @RequestMapping("/queryReceivedOrders")
    @ResponseBody
    public PagedResult<Order> queryReceivedOrders(@RequestBody Order order,
                                                  @RequestParam("pageNo") Integer pageNo,  @RequestParam("pageNo") Integer pageSize) {
        Integer publisherId = order.getPublisherId();
        Byte orderStatus = order.getOrderStatus();
        return orderService.getOrdersByPublisherId(publisherId, orderStatus, pageNo, pageSize);
    }

}
