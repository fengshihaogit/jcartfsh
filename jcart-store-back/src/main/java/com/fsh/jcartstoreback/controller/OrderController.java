package com.fsh.jcartstoreback.controller;


import com.fsh.jcartstoreback.dto.in.OrderCheckoutInDTO;
import com.fsh.jcartstoreback.dto.out.OrderListOutDTO;
import com.fsh.jcartstoreback.dto.out.OrderShowOutDTO;
import com.fsh.jcartstoreback.dto.out.PageOutDTO;
import com.fsh.jcartstoreback.po.Order;
import com.fsh.jcartstoreback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public PageOutDTO<OrderListOutDTO> getList(@RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }
}
