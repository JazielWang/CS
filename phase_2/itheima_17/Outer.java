package com.itheima_17;

// 局部内部类

public class Outer {
    public void method(){

        /*new Inter(){
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        };*/
        /*new Inter(){
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        }.show();
        new Inter(){
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        }.show();*/

        Inter i = new Inter(){
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        };
        i.show();
        i.show();
    }
}
