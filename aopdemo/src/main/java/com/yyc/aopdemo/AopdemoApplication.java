package com.yyc.aopdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        System.out.println("启动类 ----开始");
        SpringApplication.run(AopdemoApplication.class, args);
    }
}
