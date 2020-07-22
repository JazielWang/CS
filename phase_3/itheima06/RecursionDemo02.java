package com.itheima06;

public class RecursionDemo02 {
    public static void main(String[] args) {
        System.out.println(f(5));
    }

    public static int f(int n) {
        if (n == 1) {
            return 1;
        } else {
            int i = n * f(n - 1);
            return i;
        }
    }
}
