package com.itheima_22;

import com.itheima_11.Teacher;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入分数");
        int i = sc.nextInt();

        Techer t = new Techer();
        try {
            t.checkScore(i);
        } catch (ScoreException e) {
            e.printStackTrace();
        }

    }
}
