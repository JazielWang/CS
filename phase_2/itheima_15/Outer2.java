package com.itheima_15;

// 内部类必须通过外部类中的方法进行调用

public class Outer2 {
    private int age = 12;

    /*
    public class Inner{

        public void show(){
            System.out.println(age);
        }
    }
    */
    private class Inner{

        public void show(){
            System.out.println(age);
        }
    }

    public void method(){
        Inner i = new Inner();
        i.show();
    }
}
