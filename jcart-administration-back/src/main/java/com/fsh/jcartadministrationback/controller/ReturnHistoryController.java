package com.fsh.jcartadministrationback.controller;

import com.fsh.jcartadministrationback.dto.in.ReturnHistoryCreateInDTO;
import com.fsh.jcartadministrationback.dto.out.ReturnHistoryListOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-02-25 23:38
 */
@RestController
@RequestMapping("/returnhistory")
public class ReturnHistoryController {

    @GetMapping("/getListByReturnId")
    public List<ReturnHistoryListOutDTO> getListByReturnId(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){
        return null;
    }

}
