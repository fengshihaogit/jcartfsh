package com.fsh.jcartadministrationback.controller;

import com.fsh.jcartadministrationback.dto.in.OrderSearchInDTO;
import com.fsh.jcartadministrationback.dto.out.*;
import com.fsh.jcartadministrationback.service.OrderService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Blake
 * @create 2020-02-25 22:41
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/search")
    public PageOutDTO<OrderListOutDTO> search(
            OrderSearchInDTO orderSearchInDTO,@RequestParam(required = false,defaultValue = "1") Integer pageNum){

        Page<OrderListOutDTO> page = orderService.search(pageNum);

        PageOutDTO<OrderListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);


        return pageOutDTO;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        OrderShowOutDTO orderShowOutDTO = orderService.getById(orderId);
        return orderShowOutDTO;
    }

    @GetMapping("/getInvoiceInfo")
    public OrderInvoiceShowOutDTO getInvoiceInfo(@RequestParam Long orderId){
        return null;
    }

    @GetMapping("/getShipInfo")
    public OrderShipShowOutDTO getShipInfo(@RequestParam Long orderId){
        return null;
    }
}
