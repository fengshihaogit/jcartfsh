package com.fsh.jcartadministrationback.service.impl;

import com.alibaba.fastjson.JSON;
import com.fsh.jcartadministrationback.dao.CustomerMapper;
import com.fsh.jcartadministrationback.dao.OrderDetailMapper;
import com.fsh.jcartadministrationback.dao.OrderMapper;
import com.fsh.jcartadministrationback.dto.out.OrderListOutDTO;
import com.fsh.jcartadministrationback.dto.out.OrderShowOutDTO;
import com.fsh.jcartadministrationback.po.Customer;
import com.fsh.jcartadministrationback.po.Order;
import com.fsh.jcartadministrationback.po.OrderDetail;
import com.fsh.jcartadministrationback.service.CustomerService;
import com.fsh.jcartadministrationback.service.OrderService;
import com.fsh.jcartadministrationback.vo.OrderProductVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private CustomerService customerService;


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
        Customer customer = customerService.getById(order.getCustomerId());
        orderShowOutDTO.setCustomerName(customer.getRealName());
        orderShowOutDTO.setStatus(order.getStatus());
        orderShowOutDTO.setTotalPrice(order.getTotalPrice());
        orderShowOutDTO.setRewordPoints(order.getRewordPoints());
        orderShowOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
        orderShowOutDTO.setUpdateTimestamp(order.getUpdateTime().getTime());

        orderShowOutDTO.setShipMethod(orderDetail.getShipMethod());
        orderShowOutDTO.setShipAddress(orderDetail.getShipAddress());
        orderShowOutDTO.setShipPrice(orderDetail.getShipPrice());
        orderShowOutDTO.setPayMethod(orderDetail.getPayMethod());
        orderShowOutDTO.setInvoiceAddress(orderDetail.getInvoiceAddress());
        orderShowOutDTO.setInvoicePrice(orderDetail.getInvoicePrice());
        orderShowOutDTO.setComment(orderDetail.getComment());

        List<OrderProductVo> orderProductVOS = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVo.class);
        orderShowOutDTO.setOrderProducts(orderProductVOS);

        return orderShowOutDTO;
    }

    @Override
    public void update(Order order) {
            orderMapper.updateByPrimaryKeySelective(order);
    }
}
