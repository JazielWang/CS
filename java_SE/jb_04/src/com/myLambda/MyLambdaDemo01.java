package com.ithiema_01;

public class MyLambdaDemo01 {
    public static void main(String[] args) {
        //实现类的方式实现需求
        /*MyThread mt = new MyThread();
        Thread t = new Thread(mt);
        t.start();*/

        //匿名内部类的方式改进
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类多线程启动了");
            }
        }).start();*/

        //Lambda表达式的方式改进
        new Thread( () -> {
            System.out.println("lambda 多线程启动了");
        }).start();
    }
}
