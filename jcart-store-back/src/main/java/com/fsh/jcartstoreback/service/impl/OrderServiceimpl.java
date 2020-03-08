package com.fsh.jcartstoreback.service.impl;

import com.alibaba.fastjson.JSON;
import com.fsh.jcartstoreback.dao.OrderDetailMapper;
import com.fsh.jcartstoreback.dao.OrderMapper;
import com.fsh.jcartstoreback.dto.in.OrderCheckoutInDTO;
import com.fsh.jcartstoreback.dto.in.OrderProductInDTO;
import com.fsh.jcartstoreback.dto.out.OrderHistoryListOutDTO;
import com.fsh.jcartstoreback.dto.out.OrderShowOutDTO;
import com.fsh.jcartstoreback.enumeration.OrderStatus;
import com.fsh.jcartstoreback.po.*;
import com.fsh.jcartstoreback.service.AddressService;
import com.fsh.jcartstoreback.service.OrderHistoryService;
import com.fsh.jcartstoreback.service.OrderService;
import com.fsh.jcartstoreback.service.ProductService;
import com.fsh.jcartstoreback.vo.OrderProductVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mr.Blake
 * @create 2020-03-07 20:26
 */
@Service
public class OrderServiceimpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderHistoryService orderHistoryService;

    @Override
    @Transactional
    public Long checkout(OrderCheckoutInDTO orderCheckoutInDTO, Integer customerId) {

        List<OrderProductInDTO> orderProductInDTOS = orderCheckoutInDTO.getOrderProducts();
        List<OrderProductVO> orderProductVOS = orderProductInDTOS.stream().map(orderProductInDTO -> {
            Product orderProduct = productService.getById(orderProductInDTO.getProductId());
            OrderProductVO orderProductVO = new OrderProductVO();
            orderProductVO.setProductId(orderProduct.getProductId());
            orderProductVO.setProductCode(orderProduct.getProductCode());
            orderProductVO.setProductName(orderProduct.getProductName());
            Integer quantity = orderProductInDTO.getQuantity();
            orderProductVO.setQuantity(quantity);
            orderProductVO.setUnitPrice(orderProduct.getPrice());
            double unitPrice = orderProduct.getPrice() * orderProduct.getDiscount();
            orderProductVO.setUnitPrice(unitPrice);

            double totalPrice = unitPrice * orderProductInDTO.getQuantity();
            orderProductVO.setTotalPrice(totalPrice);
            Integer unitRewordPoints = orderProduct.getRewordPoints();
            orderProductVO.setUnitRewordPoints(unitRewordPoints);
            Integer totalRewordPoints = unitRewordPoints * quantity;
            orderProductVO.setTotalRewordPoints(totalRewordPoints);

            return orderProductVO;
        }).collect(Collectors.toList());

        double ALLTotalPrice = orderProductVOS.stream().mapToDouble(p -> p.getTotalPrice()).sum();

        int ALLtotalRewordPoints = orderProductVOS.stream().mapToInt(p -> p.getTotalRewordPoints()).sum();

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setStatus((byte) OrderStatus.ToProcess.ordinal());
        order.setTotalPrice(ALLTotalPrice);
        order.setRewordPoints(ALLtotalRewordPoints);
        Date date = new Date();
        order.setCreateTime(date);
        order.setUpdateTime(date);

        orderMapper.insertSelective(order);
        Long orderId = order.getOrderId();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        orderDetail.setShipMethod(orderCheckoutInDTO.getShipMethod());
        orderDetail.setShipPrice(5.0);
        Address shipAddressId = addressService.getById(orderCheckoutInDTO.getShipAddressId());
        orderDetail.setShipAddress(shipAddressId.getContent());

        orderDetail.setPayMethod(orderCheckoutInDTO.getPayMethod());
        orderDetail.setInvoicePrice(ALLTotalPrice);
        Address invoiceAddress = addressService.getById(orderCheckoutInDTO.getInvoiceAddressId());
        orderDetail.setInvoiceAddress(invoiceAddress.getContent());

        orderDetail.setComment(orderCheckoutInDTO.getComment());

        orderDetail.setOrderProducts(JSON.toJSONString(orderProductVOS));

        orderDetailMapper.insertSelective(orderDetail);
        return orderId;
    }

    @Override
    public Page<Order> getByCustomerId(Integer pageNum, Integer customerId) {

        PageHelper.startPage(pageNum,10);
        Page<Order> orders = orderMapper.selectByCustomerId(customerId);
        return orders;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);

        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setOrderId(orderId);
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

        List<OrderProductVO> orderProductVOS = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVO.class);
        orderShowOutDTO.setOrderProducts(orderProductVOS);

        List<OrderHistory> orderHistories = orderHistoryService.getByOrderId(orderId);
        List<OrderHistoryListOutDTO> orderHistoryListOutDTOS = orderHistories.stream().map(orderHistory -> {
            OrderHistoryListOutDTO orderHistoryListOutDTO = new OrderHistoryListOutDTO();
            orderHistoryListOutDTO.setTimestamp(orderHistory.getTime().getTime());
            orderHistoryListOutDTO.setOrderStatus(orderHistory.getOrderStatus());
            orderHistoryListOutDTO.setComment(orderHistory.getComment());
            return orderHistoryListOutDTO;
        }).collect(Collectors.toList());

        orderShowOutDTO.setOrderHistories(orderHistoryListOutDTOS);

        return orderShowOutDTO;
    }
}
