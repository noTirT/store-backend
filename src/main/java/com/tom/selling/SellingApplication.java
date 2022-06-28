package com.tom.selling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SellingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellingApplication.class, args);
    }
}
