package com.itheima06;

// 递归问题

public class RecursionDemo01 {
    public static void main(String[] args) {
        // 使用递归方法解决不死神兔问题

        System.out.println(f(20));
    }

    public static int f(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }
}
