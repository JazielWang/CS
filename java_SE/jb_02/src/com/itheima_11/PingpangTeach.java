package com.itheima_11;

public class PingpangTeach extends Teacher implements SpeckEnglish{

    public PingpangTeach() {
    }

    public PingpangTeach(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("吃教练的饭");
    }

    @Override
    public void teach() {
        System.out.println("教你乒乓球");
    }

    @Override
    public void English() {
        System.out.println("乒乓球教练学英语");
    }
}
