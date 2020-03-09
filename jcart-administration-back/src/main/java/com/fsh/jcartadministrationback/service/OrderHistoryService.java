package com.fsh.jcartadministrationback.service;

import com.fsh.jcartadministrationback.po.OrderHistory;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-09 21:58
 */
public interface OrderHistoryService {

    List<OrderHistory> getByOrderId(Long orderId);

    Long create(OrderHistory orderHistory);
}
