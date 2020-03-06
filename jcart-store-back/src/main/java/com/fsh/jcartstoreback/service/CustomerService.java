package com.fsh.jcartstoreback.service;

import com.fsh.jcartstoreback.dto.in.CustomerRegisterInDTO;
import com.fsh.jcartstoreback.po.Customer;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mr.Blake
 * @create 2020-03-01 16:22
 */
public interface CustomerService {

    Integer register(CustomerRegisterInDTO customerRegisterInDTO);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    Customer getByEmail(String email);

    void update(Customer customer);
}
