package com.fsh.jcartstoreback.service.impl;

import com.fsh.jcartstoreback.dao.OrderHistoryMapper;
import com.fsh.jcartstoreback.po.OrderHistory;
import com.fsh.jcartstoreback.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-08 21:34
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
}
