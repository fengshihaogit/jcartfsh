package com.fsh.jcartstoreback.service;

import com.fsh.jcartstoreback.po.OrderHistory;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-08 21:34
 */
public interface OrderHistoryService {

    List<OrderHistory> getByOrderId(Long orderId);
}
