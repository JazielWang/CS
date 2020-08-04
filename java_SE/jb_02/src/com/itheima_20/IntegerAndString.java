package com.itheima_20;
/*
       int 和 String 之间的转换
*/


public class IntegerAndString {
    public static void main(String[] args) {
        // int---String
        int num = 100;
        // 方法1
        String s1 = "" +num;
        System.out.println(s1);
        // 方法2 public static String valueOf(int i)
        String s2 = String.valueOf(num);
        System.out.println(s2);
        System.out.println("--------------------");

        // String --- int
        String s = "100";
        // 方法1
        // int --- Integer --- String
        Integer i = Integer.valueOf(s);
        // public int intValue()
        int x = i.intValue();
        System.out.println(x);
        // 方法2
        // public Static int parseInt(String s)
        int y = Integer.parseInt(s);
        System.out.println(y);
    }
}
