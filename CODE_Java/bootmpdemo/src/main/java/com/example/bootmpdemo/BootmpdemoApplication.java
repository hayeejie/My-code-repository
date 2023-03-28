package com.example.bootmpdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.bootmpdemo.mapper")
public class BootmpdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootmpdemoApplication.class, args);
    }

}
