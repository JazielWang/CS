package com.itheima_21;
/*
    异常
 */
public class ExceptionDemo01 {
    public static void main(String[] args) {
        method();
    }

    public static void method(){
        int[] arr = {23, 25, 252};
//        System.out.println(arr[1]);
        System.out.println(arr[3]);//ArrayIndexOutOfBoundsException

    }
}
