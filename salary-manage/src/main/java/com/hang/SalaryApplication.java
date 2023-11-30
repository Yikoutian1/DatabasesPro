package com.hang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SalaryApplication
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/11/30 030 16:13
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.hang.mapper")
public class SalaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(SalaryApplication.class,args);
    }
}
