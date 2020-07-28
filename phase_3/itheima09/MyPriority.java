package com.itheima09;
/*
    Thread类中设置和获取线程优先级的方法
        public final void setPriority(int newPriority)：更改此线程的优先级
        public final int getPriority()：返回此线程的优先级
 */
public class MyPriority {
    public static void main(String[] args) {
        MyThread02 mt1 = new MyThread02();
        MyThread02 mt2 = new MyThread02();
        MyThread02 mt3 = new MyThread02();

        mt1.setName("高铁");
        mt2.setName("飞机");
        mt3.setName("公交");


        /*System.out.println(mt1.getPriority());// 5
        System.out.println(mt2.getPriority());// 5
        System.out.println(mt3.getPriority());// 5*/

        mt1.setPriority(5);
        mt2.setPriority(10);
        mt3.setPriority(1);

        mt1.start();
        mt2.start();
        mt3.start();

    }
}
