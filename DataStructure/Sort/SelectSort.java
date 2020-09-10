package com.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        /*int[] arr = {3, 9, -1, 10, 20};
        selectSort(arr);
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
        selectSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    //在推导的过程，我们发现了规律，因此，可以使用for来解决
    //选择排序时间复杂度是 O(n^2)
    public static void selectSort(int[] arr){
        int temp = 0;
//        boolean flag = false;
        for (int j = 0; j < arr.length; j++) {
            int min = arr[j];
            for (int i = 1 + j; i < arr.length; i++) {
                if (min > arr[i]) {// 说明假定的最小值，并不是最小
                    min = arr[i];// 重置min
                    temp = i;// 重置minIndex
//                    flag = true;
                }
            }
            /*if (!flag){
                break;
            }else {
                flag = false;
            }
            arr[temp] = arr[j];
            arr[j] = min;*/

            // 将最小值，放在arr[0], 即交换
            if (temp != j){
                arr[temp] = arr[j];
                arr[j] = min;
            }
        }
    }
}
