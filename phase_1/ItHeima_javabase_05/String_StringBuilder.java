package com.ItHeima_javabase_05;

public class String_StringBuilder {
    public static void main(String[] args) {

        // 将StingBuilder 转换为 String
        StringBuilder sb = new StringBuilder();
        sb.append("helloworld");

        String s = sb.toString();
        System.out.println(s);


        // 通过构造方法，将 String 转化为 StringBuilder
        String s2 = "abc";

        StringBuilder sb2 = new StringBuilder(s2);
        System.out.println(sb2);
    }
}
