package com.fsh.jcartstoreback.service;

import com.fsh.jcartstoreback.dto.out.ProductListOutDTO;
import com.fsh.jcartstoreback.po.ProductOperation;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-24 22:50
 */
public interface ProductOprationService {
    void  count(Integer productId);

    List<ProductOperation> selectHotProduct();
}
