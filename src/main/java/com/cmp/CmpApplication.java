package com.cmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mapper包的位置
@MapperScan("com.cmp.mapper")
public class CmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmpApplication.class, args);
    }
}
