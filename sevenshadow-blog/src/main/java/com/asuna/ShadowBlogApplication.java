package com.asuna;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@MapperScan("com.asuna.mapper")
@SpringBootApplication
@EnableScheduling
public class ShadowBlogApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShadowBlogApplication.class, args);
    }
}
