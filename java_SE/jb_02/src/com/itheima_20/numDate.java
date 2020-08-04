package com.itheima_20;

import java.util.Calendar;
import java.util.Scanner;

/*
    二月天案例
 */
public class numDate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        int i = sc.nextInt();
        Calendar c = Calendar.getInstance();
        c.set(i, 2, 1);
        c.add(Calendar.DATE, -1);
        int ii = c.get(Calendar.DATE);
        System.out.println(i + "年二月有" + ii + "天");

    }
}
