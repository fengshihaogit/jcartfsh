package com.fsh.jcartadministrationback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.fsh.jcartadministrationback.dao")
@EnableAsync
public class JcartAdministrationBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(JcartAdministrationBackApplication.class, args);
    }

}
