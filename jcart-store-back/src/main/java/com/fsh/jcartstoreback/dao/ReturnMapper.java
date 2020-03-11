package com.fsh.jcartstoreback.dao;

import com.fsh.jcartstoreback.po.Return;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnMapper {
    int deleteByPrimaryKey(Integer returnId);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer returnId);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    //custom

    Page<Return> selectPageByCustomerId(@Param("customerId") Integer customerId);
}