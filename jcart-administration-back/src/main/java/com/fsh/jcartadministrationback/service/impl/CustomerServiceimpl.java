package com.fsh.jcartadministrationback.service.impl;

import com.fsh.jcartadministrationback.dao.CustomerMapper;
import com.fsh.jcartadministrationback.dto.in.CustomerSetStatusInDTO;
import com.fsh.jcartadministrationback.po.Customer;
import com.fsh.jcartadministrationback.service.CustomerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Blake
 * @create 2020-03-09 20:37
 */
@Service
public class CustomerServiceimpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public Page<Customer> search(Integer pageNum) {

        PageHelper.startPage(pageNum,10);
        Page<Customer> search = customerMapper.search();
        return search;
    }

    @Override
    public Customer getById(Integer customerId) {
        Customer customer = customerMapper.selectByPrimaryKey(customerId);
        return customer;
    }

    @Override
    public void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO) {
        Customer customer = new Customer();
        customer.setCustomerId(customerSetStatusInDTO.getCustomerId());
        customer.setStatus(customerSetStatusInDTO.getStatus());
        customerMapper.updateByPrimaryKeySelective(customer);
    }
}
