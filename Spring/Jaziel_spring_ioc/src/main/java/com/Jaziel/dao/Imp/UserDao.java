package com.Jaziel.dao.Imp;

import com.Jaziel.dao.UseDaoImp;
import com.Jaziel.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author 王杰
 * @time 2020/9/20 17:29
 */
public class UserDao implements UseDaoImp {
    private List<String> userName;
    private Map<String, User> user;
    private Properties properties;

    public void setUserName(List<String> userName) {
        this.userName = userName;
    }

    public void setUser(Map<String, User> user) {
        this.user = user;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*public UserDao() {
        System.out.println("UserDao 创建");
    }

    public void init() {
        System.out.println("初始化");
    }

    public void destroy() {
        System.out.println("销毁");
    }*/

    @Override
    public void save() {
//        System.out.println(name + "===" + age);
        System.out.println(userName);
        System.out.println(user);
        System.out.println(properties);
        System.out.println("save running...");
    }
}
