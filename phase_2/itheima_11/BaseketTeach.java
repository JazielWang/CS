package com.itheima_11;

public class BaseketTeach extends Teacher{

    public BaseketTeach() {
    }

    public BaseketTeach(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("吃教练的饭");
    }

    @Override
    public void teach() {
        System.out.println("教你打篮球");
    }
}
