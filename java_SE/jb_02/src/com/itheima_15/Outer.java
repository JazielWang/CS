package com.itheima_15;

// 内部类

public class Outer {

    private int age = 12;

    public class Inner{

        public void show(){
            System.out.println(age);
        }
    }

    public void method(){
//        show();
        Inner i = new Inner();
        i.show();
    }
}
