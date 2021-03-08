package com.Jaziel.web;

import com.Jaziel.Service.userService;
import com.Jaziel.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author 王杰
 * @time 2020/9/26 16:44
 */
public class userControl {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        userService bean = app.getBean(userService.class);
        bean.save();
    }
}
