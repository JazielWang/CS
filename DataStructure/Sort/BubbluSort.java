package com.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbluSort {
    public static void main(String[] args) {
        /*int[] arr = {3, 9, -1, 10, 20};
        Bubble(arr);
        System.out.println(Arrays.toString(arr));*/
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * 80000);
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        Bubble(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    // 将前面额冒泡排序算法，封装成一个方法
    public static void Bubble(int[] arr) {
        // 冒泡排序 的时间复杂度 O(n^2), 自己写出
        int temp;// 临时变量
        boolean flag = false;// 标识变量，表示是否进行过交换
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!flag){// 在一趟排序中，一次交换都没有发生过
                break;
            }else {
                flag = false;// 重置flag!!!, 进行下次判断
            }
        }
    }
}
