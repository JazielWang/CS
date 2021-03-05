package com.Jaziel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import javax.swing.*;

/**
 * @author 王杰
 * @time 2020/11/3 18:25
 * spring boot 都会有一个启动引导类，这是工程的入口
 * 并在引导类上添加 @SpringBootApplication
 */
@SpringBootApplication
@MapperScan("com.Jaziel.mapper")
public class Application {
    // 启动代码
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
