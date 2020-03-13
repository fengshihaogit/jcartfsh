package com.fsh.jcartadministrationback.dao;

import com.fsh.jcartadministrationback.po.Return;
import com.github.pagehelper.Page;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReturnMapper {
    int deleteByPrimaryKey(Integer returnId);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer returnId);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    //custom
    Page<Return> search(
            @Param("returnId")Integer returnId,
            @Param("orderId") Long orderId,
            @Param("startTime")Date startTime,
            @Param("endTime")Date endTime,
            @Param("status") Byte status,
            @Param("productCode") String productCode,
            @Param("customerName") String customerName,
            @Param("productName")String productName);
}