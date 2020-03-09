package com.fsh.jcartadministrationback.dao;

import com.fsh.jcartadministrationback.po.Customer;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    //custom

    Page<Customer> search();
}