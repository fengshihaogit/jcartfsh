package com.fsh.jcartstoreback.dao;

import com.fsh.jcartstoreback.po.Order;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //custom

    Page<Order> selectByCustomerId(@Param("customerId") Integer customerId);

}