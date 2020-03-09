package com.fsh.jcartadministrationback.service.impl;

import com.fsh.jcartadministrationback.dao.OrderDetailMapper;
import com.fsh.jcartadministrationback.dao.OrderMapper;
import com.fsh.jcartadministrationback.dto.out.OrderListOutDTO;
import com.fsh.jcartadministrationback.dto.out.OrderShowOutDTO;
import com.fsh.jcartadministrationback.po.Order;
import com.fsh.jcartadministrationback.po.OrderDetail;
import com.fsh.jcartadministrationback.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Blake
 * @create 2020-03-09 15:19
 */
@Service
public class OrderServiceimpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;


    @Override
    public Page<OrderListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);

        Page<OrderListOutDTO> search = orderMapper.search();

        return search;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);

        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setOrderId(orderId);
        orderShowOutDTO.setCustomerId(order.getCustomerId());
        return null;
    }
}
