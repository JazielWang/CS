package com.ItHeima_javabase_04;

// 学生类

public class Student {
    //成员变量
    private String name;
    private int age;

    // 构造方法
    public Student(){
        System.out.println("无参构造方法");
    }

    //get/name 方法
    public void setName(String name){
        // name = name;
        // this.name 中 name指的是成员变量
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void  setAge(int x){
        age = x;
    }
    public  int getAge(){
        return age;
    }

    public void show(){
        System.out.println(name + "," + age);
    }
}
