package com.fsh.jcartadministrationback.dao;

import com.fsh.jcartadministrationback.po.Return;
import com.github.pagehelper.Page;
import com.sun.org.apache.regexp.internal.RE;
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
    Page<Return> search();
}