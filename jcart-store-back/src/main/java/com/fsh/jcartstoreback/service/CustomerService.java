package com.fsh.jcartstoreback.service;

import com.fsh.jcartstoreback.dto.in.CustomerRegisterInDTO;

/**
 * @author Mr.Blake
 * @create 2020-03-01 16:22
 */
public interface CustomerService {

    Integer register(CustomerRegisterInDTO customerRegisterInDTO);
}
