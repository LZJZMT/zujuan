package com.zujuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.zujuan.mapper")
@SpringBootApplication
public class ZujuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZujuanApplication.class, args);
    }

}

