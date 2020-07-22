package com.ItHeima_javabase_05;

public class StringbuilderDemo {
    public static void main(String[] args) {

        // 构建StringBuilder对象字符串
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);
        System.out.println(sb.length());

        StringBuilder sbsb = new StringBuilder("hello");
        System.out.println(sbsb);
        System.out.println(sbsb.length());

        // StingBulider 的添加和反转
        // 添加StringBuilder append()，添加数据，并返回对象本身
        StringBuilder sb2 = sb.append("helloworld");
        System.out.println("sb:" + sb);
        System.out.println("sb2:" + sb2);
        System.out.println(sb == sb2);

        // 链式编程
        sb.append("hello").append("world").append(100);
        System.out.println("sb:" + sb);

        // StringBuilder reverse() 返回相反的字符串
        sb.reverse();
        System.out.println("sb:" + sb);
    }
}
