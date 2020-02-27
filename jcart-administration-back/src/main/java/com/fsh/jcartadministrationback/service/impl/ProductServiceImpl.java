package com.fsh.jcartadministrationback.service.impl;

import com.alibaba.fastjson.JSON;
import com.fsh.jcartadministrationback.dao.ProductDetailMapper;
import com.fsh.jcartadministrationback.dao.ProductMapper;
import com.fsh.jcartadministrationback.dto.in.ProductCreateInDTO;
import com.fsh.jcartadministrationback.dto.in.ProductUpdateInDTO;
import com.fsh.jcartadministrationback.po.Product;
import com.fsh.jcartadministrationback.po.ProductDetail;
import com.fsh.jcartadministrationback.service.ProductServiceinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-02-27 14:17
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductServiceinter {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;


    @Override
    public Integer create(ProductCreateInDTO productCreateInDTO) {

        Product product = new Product();
        product.setProductCode(productCreateInDTO.getProductCode());
        product.setProductName(productCreateInDTO.getProductName());
        product.setPrice(productCreateInDTO.getPrice());
        product.setDiscount(productCreateInDTO.getDiscount());
        product.setStockQuantity(productCreateInDTO.getStockQuantity());
        product.setStatus(productCreateInDTO.getStatus());
        product.setMainPicUrl(productCreateInDTO.getMainPicUrl());
        product.setRewordPoints(productCreateInDTO.getRewordPoints());
        product.setSortOrder(productCreateInDTO.getSortOrder());
        String description = productCreateInDTO.getDescription();
        String substring = description.substring(0, Math.min(100, description.length()));
        product.setProductAbstract(substring);
        productMapper.insertSelective(product);

        Integer productId = product.getProductId();

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productId);
        productDetail.setDescription(productCreateInDTO.getDescription());
        List<String> otherPicUrls = productCreateInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));
        productDetailMapper.insertSelective(productDetail);



        return productId;
    }

    @Override
    @Transactional
    public void update(ProductUpdateInDTO productUpdateInDTO) {
        Product product = new Product();
        product.setProductId(productUpdateInDTO.getProductId());
        product.setProductName(productUpdateInDTO.getProductName());
        product.setPrice(productUpdateInDTO.getPrice());
        product.setDiscount(productUpdateInDTO.getDiscount());
        product.setStockQuantity(productUpdateInDTO.getStockQuantity());
        product.setMainPicUrl(productUpdateInDTO.getMainPicUrl());
        product.setStatus(productUpdateInDTO.getStatus());
        product.setRewordPoints(productUpdateInDTO.getRewordPoints());
        product.setSortOrder(productUpdateInDTO.getSortOrder());
        String description = productUpdateInDTO.getDescription();
        String substring = description.substring(0, Math.min(100, description.length()));
        product.setProductAbstract(substring);

        productMapper.updateByPrimaryKeySelective(product);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productUpdateInDTO.getProductId());
        productDetail.setDescription(productUpdateInDTO.getDescription());
        List<String> otherPicUrls = productUpdateInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));

        productDetailMapper.updateByPrimaryKeySelective(productDetail);
    }


}
