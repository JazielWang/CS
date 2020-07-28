package com.itheima09;
/*
    方式1：继承Thread类
        1:定义一个类MyThread继承Thread类
        2:在MyThread类中重写run()方法
        3:创建MyThread类的对象
        4:启动线程
 */
public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        MyThread mt2 = new MyThread();

//        mt.run();
//        mt2.run();

        mt.start();
        mt2.start();

    }
}
