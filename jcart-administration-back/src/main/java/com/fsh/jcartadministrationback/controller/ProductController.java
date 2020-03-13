package com.fsh.jcartadministrationback.controller;

import com.fsh.jcartadministrationback.dto.in.ProductCreateInDTO;
import com.fsh.jcartadministrationback.dto.in.ProductSearchInDTO;
import com.fsh.jcartadministrationback.dto.in.ProductUpdateInDTO;
import com.fsh.jcartadministrationback.dto.out.PageOutDTO;
import com.fsh.jcartadministrationback.dto.out.ProductListOutDTO;
import com.fsh.jcartadministrationback.dto.out.ProductShowOutDTO;
import com.fsh.jcartadministrationback.service.ProductServiceinter;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-02-25 20:49
 */
@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductServiceinter productServiceinter;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<ProductListOutDTO> page = productServiceinter.search(productSearchInDTO,pageNum);

        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();

        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);
        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        ProductShowOutDTO productShowOutDTO = productServiceinter.getById(productId);
        return productShowOutDTO;
    }

    @PostMapping("/create")
    public Integer create (@RequestBody ProductCreateInDTO productCreateInDTO){
        return productServiceinter.create(productCreateInDTO);
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){
        productServiceinter.update(productUpdateInDTO);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer productId){
        productServiceinter.delete(productId);
    }

    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> productIds){
        productServiceinter.batchDelete(productIds);
    }

}
