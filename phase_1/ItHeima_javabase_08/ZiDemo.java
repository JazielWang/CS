package com.ItHeima_javabase_08;

public class ZiDemo extends FuDemo {

    public int age = 20;

    public void show(){
        int age = 30;
        System.out.println(age);
        // 我要访问本类的成员变量age，怎么办呢？
        System.out.println(this.age);
        // 我要访问父类的成员的age，怎么办呢？
        System.out.println(super.age);
    }
}
