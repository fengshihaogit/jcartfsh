package com.fsh.jcartadministrationback.service.impl;

import com.fsh.jcartadministrationback.dao.OrderHistoryMapper;
import com.fsh.jcartadministrationback.po.OrderHistory;
import com.fsh.jcartadministrationback.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-09 21:59
 */
@Service
public class OrderHistoryServiceimpl implements OrderHistoryService {

    @Autowired
    private OrderHistoryMapper orderHistoryMapper;


    @Override
    public List<OrderHistory> getByOrderId(Long orderId) {

        List<OrderHistory> orderHistories = orderHistoryMapper.selectByOrderId(orderId);
        return orderHistories;
    }

    @Override
    public Long create(OrderHistory orderHistory) {
        orderHistoryMapper.insertSelective(orderHistory);
        Long orderHistoryId = orderHistory.getOrderHistoryId();
        return orderHistoryId;
    }
}
