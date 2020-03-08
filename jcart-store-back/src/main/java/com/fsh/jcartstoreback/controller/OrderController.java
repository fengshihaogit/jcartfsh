package com.fsh.jcartstoreback.controller;


import com.fsh.jcartstoreback.dto.in.OrderCheckoutInDTO;
import com.fsh.jcartstoreback.dto.out.OrderListOutDTO;
import com.fsh.jcartstoreback.dto.out.OrderShowOutDTO;
import com.fsh.jcartstoreback.dto.out.PageOutDTO;
import com.fsh.jcartstoreback.po.Order;
import com.fsh.jcartstoreback.service.OrderService;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout")
    public Long checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){
        Long checkout = orderService.checkout(orderCheckoutInDTO, customerId);
        return checkout;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestAttribute Integer customerId){

        Page<Order> page = orderService.getByCustomerId(pageNum, customerId);

        List<OrderListOutDTO> orderListOutDTOS = page.stream().map(order -> {
            OrderListOutDTO orderListOutDTO = new OrderListOutDTO();
            orderListOutDTO.setOrderId(order.getOrderId());
            orderListOutDTO.setStatus(order.getStatus());
            orderListOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
            orderListOutDTO.setTotalPrice(order.getTotalPrice());
            return orderListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<OrderListOutDTO> PageOutDTO = new PageOutDTO<>();

        PageOutDTO.setTotal(page.getTotal());
        PageOutDTO.setPageNum(page.getPageNum());
        PageOutDTO.setPageSize(page.getPageSize());
        PageOutDTO.setList(orderListOutDTOS);
        return PageOutDTO;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId) {
        OrderShowOutDTO orderShowOutDTO = orderService.getById(orderId);
        return orderShowOutDTO;
    }
}
