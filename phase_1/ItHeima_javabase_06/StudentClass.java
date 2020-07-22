package com.ItHeima_javabase_06;

import java.awt.print.Pageable;

public class StudentClass {
    private String name;
    private int age;

    public StudentClass(){}
    public StudentClass(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
