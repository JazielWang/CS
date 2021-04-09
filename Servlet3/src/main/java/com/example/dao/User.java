package com.example.dao;

import java.util.Date;

/**
 * @author 王杰
 * @date 2021/4/9 12:38
 */
public class User {
    private String name;
    private int age;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User() {
    }

    public User(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }
}
