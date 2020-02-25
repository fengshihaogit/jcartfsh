package com.fsh.jcartadministrationback.controller;

import com.fsh.jcartadministrationback.dto.in.CustomerSearchDTO;
import com.fsh.jcartadministrationback.dto.out.CustomerListOutDTO;
import com.fsh.jcartadministrationback.dto.out.CustomerShowOutDTO;
import com.fsh.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mr.Blake
 * @create 2020-02-25 22:19
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(
            CustomerSearchDTO customerSearchDTO, @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
        return null;
    }

    @PostMapping("/disable")
    public void disable(@RequestParam Integer customerId){

    }
}
