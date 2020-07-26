package com.itheima07;

public class Student {
    private int num;
    private String name;
    private int age;
    private String address;

    public Student(int num, String name, int age, String address) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
