package com.itheima_15;
/*
       这是 Outer2 的测试类
*/
public class InnerDemo2 {
    public static void main(String[] args) {
        // 创建内部类对象，并调用方法
        /*Outer2.Inner oi = new Outer2().new Inner()
        oi.show();*/

        Outer2 o = new Outer2();
        o.method();
    }
}
