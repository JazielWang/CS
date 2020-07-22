package com.itheima_20;

import java.util.Arrays;

public class IntegerTest {
    public static void main(String[] args) {

        // 定义一个字符串
        String s = "91 26 25 34 24 26 65";
        // 把字符串中的数字数据储存到一个int类型的数组中
        String[] strArray = s.split(" ");
        /*for (int i = 0; i < strArray.length; i++){
            System.out.println(strArray[i]);
        }*/
        int[] arr = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++){
            arr[i] = Integer.parseInt(strArray[i]);
        }
        /*for (int i = 0; i< arr.length; i++){
            System.out.println(arr[i]);
        }*/
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            if (i == arr.length -1){
                sb.append(arr[i]);
            }else {
                sb.append(arr[i]).append(" ");
            }
        }
        String s2 = sb.toString();
        System.out.println(s2);
    }
}
