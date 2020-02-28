package com.fsh.jcartadministrationback.service;

import com.fsh.jcartadministrationback.dto.in.ProductCreateInDTO;
import com.fsh.jcartadministrationback.dto.in.ProductUpdateInDTO;
import com.fsh.jcartadministrationback.dto.out.ProductListOutDTO;
import com.fsh.jcartadministrationback.dto.out.ProductShowOutDTO;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-02-27 14:16
 */
public interface ProductServiceinter {

    Integer create(ProductCreateInDTO productCreateInDTO);

    void update(ProductUpdateInDTO productUpdateInDTO);

    void delete (Integer productId);

    void batchDelete(List<Integer> productIds);

    Page<ProductListOutDTO> search(Integer pageNum);

    ProductShowOutDTO getById(Integer productId);
}