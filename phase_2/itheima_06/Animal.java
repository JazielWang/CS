package com.itheima_06;

// 抽象类
public abstract class Animal {

    private int age = 20;
    private final String city = "qingdao";

    public Animal(){}

    public Animal(int age) {
        this.age = age;
    }

    public void show(){
        age = 40;
        System.out.println(age);
//        city = "shanghai";
        System.out.println(city);
    }

    public abstract void eat();

}
