package com.ItHeima_javabase_3;

public class Student {
    String name;
    private int age;

    public void setAge(int a) {
        if (a < 0 || a > 120){
            System.out.println("输入年龄有误");
        }else {
            age = a;
        }
    }

    public int getAge() {
        return age;
    }

    public void study() {
        System.out.println("learning");
    }

    public void doHomework() {
        System.out.println("do homework");
    }
    public void show(){
        System.out.println(age + "," + name);
    }

}
