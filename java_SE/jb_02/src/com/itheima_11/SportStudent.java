package com.itheima_11;

public abstract class SportStudent extends Person{

    public SportStudent() {
    }

    public SportStudent(String name, int age) {
        super(name, age);
    }


    public abstract void learn();

}
