package com.ItHeima_javabase_2;

import java.util.jar.JarOutputStream;

public class ArrayDemo {
    public static void main(String[] args) {

        // 数组初始化之动态初始化
        int[] arr = new int[3];
        int[] arr2 = new int [2];

        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr2);
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);

        // 为数组赋值
        arr[0] = 100;
        arr2[0] = 200;
        arr2[1] = 300;

        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr2);
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);

        // 多个数组指向相同
        int arr3[] = arr;

        arr3[0] = 111;
        arr3[1] = 222;
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr3);
        System.out.println(arr3[0]);

        //数组初始化之静态初始化
        int[] arr5 = {1, 2, 3};
        System.out.println(arr5);
        System.out.println(arr5[0]);
        System.out.println(arr5[1]);
        System.out.println(arr5[2]);

        // 索引越界 ArrayIndexOutOfBoundsException
        /*System.out.println(arr[3]);*/
        // 空指针异常 NullPointerException
        /*arr = null;
        System.out.println(arr[0]);*/

        // 通用遍历格式
        for(int x =0; x < arr.length; x++){
            System.out.println(arr[x]);
        }

        // 获取最值
        int max = arr[0];
        for (int x =1; x < arr.length; x++){
            if (arr[x] > max){
                max = arr[x];
            }
        }
        System.out.println(max);
    }
}