package com.fsh.jcartsupportback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class JcartSupportBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(JcartSupportBackApplication.class, args);
    }

}
