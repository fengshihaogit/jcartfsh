package com.fsh.jcartstoreback.controller;


import com.alibaba.fastjson.JSON;
import com.fsh.jcartstoreback.dto.in.ProductSearchInDTO;
import com.fsh.jcartstoreback.dto.out.PageOutDTO;
import com.fsh.jcartstoreback.dto.out.ProductListOutDTO;
import com.fsh.jcartstoreback.dto.out.ProductShowOutDTO;
import com.fsh.jcartstoreback.es.doc.ProductDoc;
import com.fsh.jcartstoreback.es.repo.ProductRepo;
import com.fsh.jcartstoreback.mq.HotProductDTO;
import com.fsh.jcartstoreback.po.Product;
import com.fsh.jcartstoreback.po.ProductOperation;
import com.fsh.jcartstoreback.service.ProductOprationService;
import com.fsh.jcartstoreback.service.ProductService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
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
    private ProductOprationService productOprationService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){

        String keyword = productSearchInDTO.getKeyword();
        List<ProductDoc> productDocs = productRepo.findByProductNameLikeOrProductAbstractLike(keyword, keyword);

        Page<ProductListOutDTO> page = productService.search(productSearchInDTO,pageNum);

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
//    @Cacheable(cacheNames = "HotProducts")
    public List<ProductOperation> hot(){

        String hotProducts = redisTemplate.opsForValue().get("HotProduct");
        if(hotProducts != null){
            List<ProductOperation> productOperations = JSON.parseArray(hotProducts, ProductOperation.class);
            return productOperations;
        } else {
            List<ProductOperation> productOperation = productOprationService.selectHotProduct();
            redisTemplate.opsForValue().set("HotProduct",JSON.toJSONString(productOperation));
            return productOperation;
        }

    }

}
