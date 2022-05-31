package com.weng.test_simple_app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.weng.test_simple_app.mapper")
public class TestSimpleAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestSimpleAppApplication.class, args);
  }
}
