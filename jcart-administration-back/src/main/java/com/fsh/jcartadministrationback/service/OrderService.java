package com.fsh.jcartadministrationback.service;

import com.fsh.jcartadministrationback.dto.in.OrderSearchInDTO;
import com.fsh.jcartadministrationback.dto.out.OrderListOutDTO;
import com.fsh.jcartadministrationback.dto.out.OrderShowOutDTO;
import com.fsh.jcartadministrationback.po.Order;
import com.github.pagehelper.Page;

/**
 * @author Mr.Blake
 * @create 2020-03-09 15:18
 */
public interface OrderService {

    Page<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,Integer pageNum);

    OrderShowOutDTO getById(Long orderId);

    void update (Order order);
}
