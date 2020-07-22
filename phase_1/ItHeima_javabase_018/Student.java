package com.ItHeima_javabase_018;

public class Student {

    private String name;
    private static String university;

    public void show1(){
        System.out.println("非静态方法");
    }
    public void show2(){
        System.out.println(name);
        System.out.println(university);
        show1();
        show3();
    }

    public static void show3(){

    }
    public static void show4(){
        System.out.println("静态方法");
//        System.out.println(name);
        System.out.println(university);
//        show1();
        show3();
    }
}