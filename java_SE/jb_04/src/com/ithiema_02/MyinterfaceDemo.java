package com.ithiema_02;
/*
    需求：
        1:定义一个接口MyInterface，里面有两个抽象方法：
            void show1();
            void show2();
        2:定义接口的两个实现类：
            MyInterfaceImplOne
            MyInterfaceImplTwo
        3:定义测试类：
            MyInterfaceDemo
            在主方法中，按照多态的方式创建对象并使用
 */
public class MyinterfaceDemo {
    public static void main(String[] args) {
        MyInterface mi1 = new MyinterImpOne();
        mi1.show1();
        mi1.show2();
        mi1.show3();
    }
}
