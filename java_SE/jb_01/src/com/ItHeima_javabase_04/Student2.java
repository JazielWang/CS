package com.ItHeima_javabase_04;

/*
    构造方法
*/

public class Student2 {
    private String name;
    private int age;

    public Student2(){
        System.out.println("这是一个无参构造分案方法");
    }

    public Student2(String name){
        this.name = name;
    }

    public Student2(int age){
        this.age = age;
    }

    public Student2(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.println(name + "," + age);
    }
}
