package com.itheima_11;

public class PingpangStudent extends SportStudent implements SpeckEnglish{
    public PingpangStudent() {
    }

    public PingpangStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("吃学员的饭");
    }

    @Override
    public void learn() {
        System.out.println("学习打乒乓球");
    }

    @Override
    public void English() {
        System.out.println("学英语");
    }
}
