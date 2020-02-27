package com.fsh.jcartadministrationback.service;

import com.fsh.jcartadministrationback.dto.in.ProductCreateInDTO;
import com.fsh.jcartadministrationback.dto.in.ProductUpdateInDTO;

/**
 * @author Mr.Blake
 * @create 2020-02-27 14:16
 */
public interface ProductServiceinter {

    Integer create(ProductCreateInDTO productCreateInDTO);

    void update(ProductUpdateInDTO productUpdateInDTO);
}