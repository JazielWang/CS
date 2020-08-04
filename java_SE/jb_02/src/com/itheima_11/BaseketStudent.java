package com.itheima_11;

public class BaseketStudent extends SportStudent{

    public BaseketStudent() {
    }

    public BaseketStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("吃学员的饭");
    }

    @Override
    public void learn() {
        System.out.println("学习打篮球");
    }
}
