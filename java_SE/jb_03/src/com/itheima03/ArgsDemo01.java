package com.itheima03;
/*
    可变参数
 */
public class ArgsDemo01 {
    public static void main(String[] args) {
        System.out.println(sum(12, 24, 36, 2425, 26, 27, 273, 73));
        System.out.println(sum(12, 24, 36, 2425, 26, 13, 25, 27, 273, 73));
        System.out.println(sum(12, 24, 36, 2425, 26, 27, 27, 1551, 3, 73));
        System.out.println(sum(12, 24, 36, 2425, 26, 225, 57, 273, 73));

    }

        /*public static int sum(int b,int... a) {
            return 0;
        }*/
    public static int sum(int... a) {
        int num = 0;
        for (int i : a) {
            num += i;
        }
        return num;
    }
}
