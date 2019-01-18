package com.example.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.myproject.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// @MapperScan("com.example.myproject.mapper")
public class MyprojectApplication {
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyprojectApplication.class, args);
    }
}
