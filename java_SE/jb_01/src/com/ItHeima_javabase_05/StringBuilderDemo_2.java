package com.ItHeima_javabase_05;

import java.util.Scanner;

public class StringBuilderDemo_2 {
    public static void main(String[] args) {

        // 使用 Stringbuilder 进行字符串拼接，调用
        int[] arr = {1, 2, 3};
        String ss = oneStr(arr);
        System.out.println(ss);

        // 使用 Stringbuilder 进行字符串反转，调用
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = sc.nextLine();
        String s2 = verAtr(s);
        System.out.println("实现字符串的反转：" + s2);

    }


    // 使用 Stringbuilder 进行字符串拼接,方法
    public static String oneStr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(',');
            }
        }
        sb.append(']');
        String s = sb.toString();
        return s;
    }

    // 使用 Stringbuilder 进行字符串反转，方法
    public static String verAtr(String s) {
        /*
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String ss = sb.toString();
        return ss;
        */

        return new StringBuilder(s).reverse().toString();
    }
}
