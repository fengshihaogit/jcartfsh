package com.fsh.jcartstoreback.dao;

import com.fsh.jcartstoreback.dto.out.ProductListOutDTO;
import com.fsh.jcartstoreback.po.ProductOperation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOperationMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(ProductOperation record);

    int insertSelective(ProductOperation record);

    ProductOperation selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(ProductOperation record);

    int updateByPrimaryKey(ProductOperation record);

    //custom
    List<ProductOperation> selectHotProduct();
}