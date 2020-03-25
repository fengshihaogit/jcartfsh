package com.fsh.jcartstoreback.controller;


import com.alibaba.fastjson.JSON;
import com.fsh.jcartstoreback.dto.in.ProductSearchInDTO;
import com.fsh.jcartstoreback.dto.out.PageOutDTO;
import com.fsh.jcartstoreback.dto.out.ProductListOutDTO;
import com.fsh.jcartstoreback.dto.out.ProductShowOutDTO;
import com.fsh.jcartstoreback.mq.HotProductDTO;
import com.fsh.jcartstoreback.po.Product;
import com.fsh.jcartstoreback.po.ProductOperation;
import com.fsh.jcartstoreback.service.ProductOpreationService;
import com.fsh.jcartstoreback.service.ProductService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductOpreationService productOpreationService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){

        Page<ProductListOutDTO> page = productService.search(pageNum);

        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        ProductShowOutDTO productServiceById = productService.getshowById(productId);

        HotProductDTO hotProductDTO = new HotProductDTO();
        hotProductDTO.setProductId(productId);
        hotProductDTO.setProductCode(productServiceById.getProductCode());
        kafkaTemplate.send("hotproduct", JSON.toJSONString(hotProductDTO));
//        productOpreationService.count(productId);
        return productServiceById;
    }

    @GetMapping("/hot")
    public List<ProductListOutDTO> hot(){

        return null;
    }

}
