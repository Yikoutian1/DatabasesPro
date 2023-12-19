package com.hang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @ClassName SalaryApplication
 * @Description 主启动类
 * @Author QiuLiHang
 * @DATE 2023/11/30 030 16:13
 * @Version 1.0
 */

@SpringBootApplication
@MapperScan("com.hang.mapper")
public class SalaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(SalaryApplication.class, args);
    }
}
