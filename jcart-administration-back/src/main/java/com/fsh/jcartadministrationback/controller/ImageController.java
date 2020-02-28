package com.fsh.jcartadministrationback.controller;

import com.fsh.jcartadministrationback.constant.ClientExceptionConstant;
import com.fsh.jcartadministrationback.exception.ClientException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author Mr.Blake
 * @create 2020-02-24 21:23
 */
@RestController
@RequestMapping("/image")
public class ImageController {

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile image){
        return null;
    }
}
