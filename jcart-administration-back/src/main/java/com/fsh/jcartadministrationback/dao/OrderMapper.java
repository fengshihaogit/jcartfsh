package com.fsh.jcartadministrationback.dao;

import com.fsh.jcartadministrationback.dto.out.OrderListOutDTO;
import com.fsh.jcartadministrationback.po.Order;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //custom

    Page<OrderListOutDTO> search();
}