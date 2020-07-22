package com.itheima_19;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = {34, 97, 12, 25, 36, 51, 14};
        int[] arr2 = {23, 115, 36, 25, 73, 36, 473, 252, 34};
        System.out.println("排序前" + arraytoString(arr));

        for (int x = 0; x < arr.length - 1; x++) {
            for (int i = 0; i < arr.length - 1 - x; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序后" + arraytoString(arr));
        System.out.println("--------------------------------");
        System.out.println("排序前：" + Arrays.toString(arr2));

        Arrays.sort(arr2);

        System.out.println("排序后：" + Arrays.toString(arr2));
    }


    public static String arraytoString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(",");
            }
        }
        sb.append("]");
        String s = sb.toString();
        return s;
    }
}
