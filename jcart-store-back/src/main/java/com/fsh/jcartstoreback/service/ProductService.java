package com.fsh.jcartstoreback.service;

import com.fsh.jcartstoreback.dto.out.ProductShowOutDTO;

/**
 * @author Mr.Blake
 * @create 2020-02-28 20:53
 */
public interface ProductService {

    ProductShowOutDTO getById (Integer productId);
}
