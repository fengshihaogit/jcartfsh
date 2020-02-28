package com.fsh.jcartstoreback.service;

import com.fsh.jcartstoreback.dto.out.ProductListOutDTO;
import com.fsh.jcartstoreback.dto.out.ProductShowOutDTO;
import com.github.pagehelper.Page;

/**
 * @author Mr.Blake
 * @create 2020-02-28 20:53
 */
public interface ProductService {

    ProductShowOutDTO getById (Integer productId);

    Page<ProductListOutDTO> search(Integer pageNum);
}
