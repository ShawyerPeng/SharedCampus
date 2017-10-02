package service.impl;

import com.github.pagehelper.PageHelper;
import mapper.OrderMapper;
import mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Order;
import po.PagedResult;
import service.OrderService;
import utils.BeanUtil;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public PagedResult<Order> getOrdersByPublisherId(Integer publisherId, Byte orderStatus, Integer pageNo, Integer pageSize) {
        pageNo = (pageNo == null ? 1 : pageNo);
        pageSize = (pageSize == null ? 10 : pageSize);
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(orderMapper.selectByPublisherId(publisherId, orderStatus));
    }

    @Override
    public PagedResult<Order> getOrdersByReceiverId(Integer receiverId, Byte orderStatus, Integer pageNo, Integer pageSize) {
        pageNo = (pageNo == null ? 1 : pageNo);
        pageSize = (pageSize == null ? 10 : pageSize);
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(orderMapper.selectByReceiverId(receiverId, orderStatus));
    }



}
