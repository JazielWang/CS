package com.itheima09;
/*
    Thread类中获取和设置线程名称的方法
        void setName(String name)：将此线程的名称更改为等于参数 name
        String getName()：返回此线程的名称
 */
public class MyThreadDemo02 {
    public static void main(String[] args) {
        /*MyThread02 mt1 = new MyThread02();
        MyThread02 mt2 = new MyThread02();

        mt1.setName("高铁");
        mt2.setName("飞机");*/

        /*MyThread02 mt1 = new MyThread02("高铁");
        MyThread02 mt2 = new MyThread02("飞机");

        mt1.start();
        mt2.start();*/

        System.out.println(Thread.currentThread().getName());
    }
}
