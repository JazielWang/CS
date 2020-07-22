package com.itheima_20;
/*
    Integer 静态方法获取对象
*/
public class IntegerDemo {
    public static void main(String[] args) {
        /*Integer i = new Integer(100);
        System.out.println(i);

        Integer i2 = new Integer("100");
        System.out.println(i2);*/

        Integer i1 = Integer.valueOf(100);
        System.out.println(i1);

        Integer i2 = Integer.valueOf("100");
        System.out.println(i2);

        /*Integer i3 = Integer.valueOf("abc");
        System.out.println(i3);*/
    }
}
