package com.fsh.jcartstoreback.dao;

import com.fsh.jcartstoreback.dto.out.ProductListOutDTO;
import com.fsh.jcartstoreback.po.Product;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    //custom

    Page<ProductListOutDTO> search();
}