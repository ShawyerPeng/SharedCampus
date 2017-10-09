package service;

import po.Order;
import po.PagedResult;

public interface OrderService {
    int insertOrder(Order order);

    PagedResult<Order> getOrdersByReceiverId(Integer receiverId, Byte orderStatus, Integer pageNo, Integer pageSize);

    PagedResult<Order> getOrdersByPublisherId(Integer publisherId, Byte orderStatus, Integer pageNo, Integer pageSize);

}
