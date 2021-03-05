package com.Jaziel.controller;

import com.Jaziel.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 王杰
 * @time 2020/10/4 13:06
 */
public class AccountTest {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService bean = app.getBean(AccountService.class);
        bean.transfer("Jerry", "Dog", 1000);
    }
}
