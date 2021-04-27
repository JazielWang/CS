package com.Jaziel.controller;

import com.Jaziel.pojo.User;
import com.Jaziel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author 王杰
 * @time 2020/11/3 18:41
 */
@RestController
@RequestMapping("/user")
public class HelloController {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Value("${Jaziel.url}")
    private String JazielUrl;
    @Value("${Jaziel2.url}")
    private String Jaziel2Url;

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list(){
        return userService.list();
    }

    @RequestMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping("/hello")
    public String hello(){
        System.out.println("JazielUrl" + JazielUrl);
        System.out.println("Jaziel2Url" + Jaziel2Url);
        System.out.println("dataSource" + dataSource);
        return "hello, spring boot!";
    }
}
