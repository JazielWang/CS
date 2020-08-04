package com.ithiema_04;
/*
    函数式接口：有且仅有一个抽象方法的接口
 */
public class MyInterDemo {
    public static void main(String[] args) {
        MyInter md = () -> System.out.println("函数式接口");
        md.show();
    }
}
