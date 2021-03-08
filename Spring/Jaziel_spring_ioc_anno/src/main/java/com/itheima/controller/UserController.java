package com.itheima.controller;

import com.itheima.config.SpringConfiguration;
import com.itheima.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * @author 王杰
 * @date 2021/3/8 15:37
 */
@Controller
public class UserController {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext cont = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService us = cont.getBean(UserService.class);
        us.save();
    }
}
