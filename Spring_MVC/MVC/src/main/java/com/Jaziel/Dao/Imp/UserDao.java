package com.Jaziel.Dao.Imp;

import com.Jaziel.Dao.UseDaoImp;

/**
 * @author 王杰
 * @time 2020/9/20 17:29
 */
public class UserDao implements UseDaoImp {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void save() {
        System.out.println("save running...");
    }
}
