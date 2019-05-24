package cn.middle.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 系统启动类
 */
@ComponentScan({"cn.middle"})
@MapperScan(value = "cn.middle.mapper")
@SpringBootApplication
public class WebApplicatioin {

    public static void main(String[] args) {
        SpringApplication.run(WebApplicatioin.class, args);
        System.out.println("=================================");
        System.out.println("=============启动成功===============");
        System.out.println("=================================");
    }
    
}