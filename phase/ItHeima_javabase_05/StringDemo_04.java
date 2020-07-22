package com.ItHeima_javabase_05;

import java.util.Scanner;

public class StringDemo_04 {
    public static void main(String[] args) {

        // 遍历字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串文字：");
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            /*System.out.print("[");
            if (i == s.length() -1){
                System.out.println(s.charAt(i));
            }else {
                System.out.print(s.charAt(i) + ", ");
            System.out.println("]")
            }*/
            System.out.println(s.charAt(i));
        }


        // 统计字符次数：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数
        System.out.println("请输入一个字符串：");
        String s2 = sc.nextLine();
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < s2.length(); i++) {
            char s3 = s2.charAt(i);
            if (s3 >= 'A' && s3 <= 'Z') {
                x++;
            } else if (s3 >= 'a' && s3 <= 'z') {
                y++;
            } else if (s3 >= '0' && s3 <= '9') {
                z++;
            }
        }
        System.out.println("其中大写字母个数是：" + x);
        System.out.println("其中小写字母个数是：" + y);
        System.out.println("其中数字个数是：" + z);


        // 拼接字符串
        int[] arr = {1, 2, 3};
        System.out.println(tobeoneArr(arr));

        // 字符串反转
        System.out.println("请输入一串字符串：");
        String s3 = sc.nextLine();
        System.out.println(verStr(s3));
    }


    // 字符串拼接
    public static String tobeoneArr(int[] arr) {
        String s = "";
        s += '[';
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                s += arr[i];
            } else {
                s += arr[i];
                s += ',';
            }
        }
        s += ']';
        return s;
    }

    // 字符串反转方法
    public static String verStr(String s){
        String s1 = "";
        for (int i = 0; i < s.length(); i++){

            s1 += s.charAt(s.length()-1-i);

        }
        return s1;
    }
}
