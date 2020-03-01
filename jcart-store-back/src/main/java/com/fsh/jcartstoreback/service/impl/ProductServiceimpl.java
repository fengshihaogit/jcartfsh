package com.fsh.jcartstoreback.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.alibaba.fastjson.JSON;
import com.fsh.jcartstoreback.CustomerStatus;
import com.fsh.jcartstoreback.dao.CustomerMapper;
import com.fsh.jcartstoreback.dao.ProductDetailMapper;
import com.fsh.jcartstoreback.dao.ProductMapper;
import com.fsh.jcartstoreback.dto.in.CustomerRegisterInDTO;
import com.fsh.jcartstoreback.dto.out.ProductListOutDTO;
import com.fsh.jcartstoreback.dto.out.ProductShowOutDTO;
import com.fsh.jcartstoreback.po.Customer;
import com.fsh.jcartstoreback.po.Product;
import com.fsh.jcartstoreback.po.ProductDetail;
import com.fsh.jcartstoreback.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-02-28 20:54
 */
@Service
public class ProductServiceimpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public ProductShowOutDTO getById(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        ProductDetail productDetail = productDetailMapper.selectByPrimaryKey(productId);

        ProductShowOutDTO productShowOutDTO = new ProductShowOutDTO();
        productShowOutDTO.setProductId(product.getProductId());
        productShowOutDTO.setProductCode(product.getProductCode());
        productShowOutDTO.setProductName(product.getProductName());
        productShowOutDTO.setPrice(product.getPrice());
        productShowOutDTO.setDiscount(product.getDiscount());
        productShowOutDTO.setMainPicUrl(product.getMainPicUrl());
        productShowOutDTO.setRewordPoints(product.getRewordPoints());
        productShowOutDTO.setStockQuantity(product.getStockQuantity());

        productShowOutDTO.setDescription(productDetail.getDescription());
        String otherPicUrlsJson = productDetail.getOtherPicUrls();
        List<String> parseArray = JSON.parseArray(otherPicUrlsJson, String.class);
        productShowOutDTO.setOtherPicUrls(parseArray);


        return productShowOutDTO;
    }

    @Override
    public Page<ProductListOutDTO> search(Integer pageNum) {

        PageHelper.startPage(pageNum,10);
        Page<ProductListOutDTO> page = productMapper.search();

        return page;
    }


}
