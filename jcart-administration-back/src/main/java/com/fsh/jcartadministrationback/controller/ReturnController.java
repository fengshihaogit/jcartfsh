package com.fsh.jcartadministrationback.controller;

import com.fsh.jcartadministrationback.dto.in.ReturnSearchInDTO;
import com.fsh.jcartadministrationback.dto.in.ReturnUpdateActionInDTO;
import com.fsh.jcartadministrationback.dto.out.PageOutDTO;
import com.fsh.jcartadministrationback.dto.out.ReturnListOutDTO;
import com.fsh.jcartadministrationback.dto.out.ReturnShowOutDTO;
import com.fsh.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                                               @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/updateAction")
    public void updateAction(@RequestBody ReturnUpdateActionInDTO returnUpdateActionInDTO){

    }
}
