package com.sunlab.helloweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sunlab.helloweb.mapper")
public class HellowebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellowebApplication.class, args);
    }

}
