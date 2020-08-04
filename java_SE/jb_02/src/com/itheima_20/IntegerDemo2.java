package com.itheima_20;

public class IntegerDemo2 {
    public static void main(String[] args) {
        // 装箱：把基本数据类型转换为对应的包装类类型
        Integer i = Integer.valueOf(100);
        Integer in = 100;// 自动装箱
        System.out.println(in);

        // 拆箱：把包装类类型装换为对应的基本数据类型
        in += 200;
        System.out.println(in);

    }
}
