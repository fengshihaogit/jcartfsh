package com.fsh.jcartadministrationback.service;

import com.fsh.jcartadministrationback.dto.in.CustomerSetStatusInDTO;
import com.fsh.jcartadministrationback.po.Customer;
import com.github.pagehelper.Page;

/**
 * @author Mr.Blake
 * @create 2020-03-09 20:36
 */
public interface CustomerService {

    Page<Customer> search(Integer pageNum);

    Customer getById(Integer customerId);

    void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO);
}
