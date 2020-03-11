package com.fsh.jcartadministrationback.controller;

import com.fsh.jcartadministrationback.dto.in.ReturnSearchInDTO;
import com.fsh.jcartadministrationback.dto.in.ReturnUpdateActionInDTO;
import com.fsh.jcartadministrationback.dto.out.PageOutDTO;
import com.fsh.jcartadministrationback.dto.out.ReturnListOutDTO;
import com.fsh.jcartadministrationback.dto.out.ReturnShowOutDTO;
import com.fsh.jcartadministrationback.po.Return;
import com.fsh.jcartadministrationback.service.ReturnService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mr.Blake
 * @create 2020-02-25 23:18
 */
@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @GetMapping("/search")
    public PageOutDTO<ReturnListOutDTO> search(ReturnSearchInDTO returnSearchInDTO,
                                               @RequestParam(required = false,defaultValue = "1") Integer pageNum){

        Page<Return> page = returnService.search(pageNum);
        List<ReturnListOutDTO> returnListOutDTOS = page.stream().map(aReturn -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setReturnId(aReturn.getReturnId());
            returnListOutDTO.setOrderId(aReturn.getOrderId());
            returnListOutDTO.setCustomerId(aReturn.getCustomerId());
            returnListOutDTO.setCustomerName(aReturn.getCustomerName());
            returnListOutDTO.setProductCode(aReturn.getProductCode());
            returnListOutDTO.setProductName(aReturn.getProductName());
            returnListOutDTO.setStatus(aReturn.getStatus());
            returnListOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
            returnListOutDTO.setUpdateTimestamp(aReturn.getUpdateTime().getTime());
            return returnListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<ReturnListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(returnListOutDTOS);
        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/updateAction")
    public void updateAction(@RequestBody ReturnUpdateActionInDTO returnUpdateActionInDTO){

    }
}
