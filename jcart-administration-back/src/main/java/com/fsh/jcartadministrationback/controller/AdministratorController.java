package com.fsh.jcartadministrationback.controller;

import com.fsh.jcartadministrationback.dto.in.AdministratorLoginInDTO;
import com.fsh.jcartadministrationback.dto.in.AdministratorUpdateProfileInDTO;
import com.fsh.jcartadministrationback.dto.out.AdministratorGetProfileOutDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mr.Blake
 * @create 2020-02-24 21:28
 */
@RestController
@RequestMapping("/admininistrator")
public class AdministratorController {

    @GetMapping("/login")
    public String login(AdministratorLoginInDTO administratorLoginInDTO){
        return null;
    }

    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfileOutDTO(Integer administratorId){
        return null;
    }

    @PostMapping("/updateProfile")
    public void updateProdfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){

    }
}
