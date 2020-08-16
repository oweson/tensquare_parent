package com.tensquare.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
// 开启异步
public class RabbitApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitApplication.class);
    }
}
