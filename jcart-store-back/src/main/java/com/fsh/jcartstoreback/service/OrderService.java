package com.fsh.jcartstoreback.service;

import com.fsh.jcartstoreback.dto.in.OrderCheckoutInDTO;

/**
 * @author Mr.Blake
 * @create 2020-03-07 20:25
 */
public interface OrderService {


    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,Integer customerId);
}