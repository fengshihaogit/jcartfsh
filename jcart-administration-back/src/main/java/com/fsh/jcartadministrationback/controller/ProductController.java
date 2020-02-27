package com.fsh.jcartadministrationback.controller;

import com.fsh.jcartadministrationback.dto.in.ProductCreateInDTO;
import com.fsh.jcartadministrationback.dto.in.ProductSearchInDTO;
import com.fsh.jcartadministrationback.dto.in.ProductUpdateInDTO;
import com.fsh.jcartadministrationback.dto.out.PageOutDTO;
import com.fsh.jcartadministrationback.dto.out.ProductListOutDTO;
import com.fsh.jcartadministrationback.dto.out.ProductShowOutDTO;
import com.fsh.jcartadministrationback.service.ProductServiceinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-02-25 20:49
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceinter productServiceinter;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        return null;
    }

    @PostMapping("/create")
    public Integer create (@RequestBody ProductCreateInDTO productCreateInDTO){
        return productServiceinter.create(productCreateInDTO);
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){

    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer productId){

    }

    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> productIds){

    }

}
