package com.itheima_16;

// 局部内部类：通过在方法中常见对象进行调用

public class Outer {
    public int num = 12;
    public void method(){
        int num2 = 20;
        class Inner {
            public void show(){
                System.out.println(num);
                System.out.println(num2);
            }
        }

        Inner i = new Inner();
        i.show();
    }
}
