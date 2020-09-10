package com.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {12, 78, 92, 45, 10, 10, 10, 122};
        Arrays.sort(arr);
        /*int i = binarySearch(arr, 0, arr.length - 1, 92);
        System.out.println("寻找的数字在数组中的" + i + "号位置");*/
        ArrayList<Integer> integers = binarySearch2(arr, 0, arr.length - 1, 10);
        System.out.println(integers);

    }

    /**
     *
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param value 要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midvalue = arr[mid];
        if (value > midvalue) {// 向 右递归
            return binarySearch(arr, mid + 1, right, value);
        } else if (value < midvalue){// 向左递归
            return binarySearch(arr, left, mid - 1, value);
        }else {
            return mid;
        }
    }

    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int value) {
        if (left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midvalue = arr[mid];
        if (value > midvalue) {// 向 右递归
            return binarySearch2(arr, mid + 1, right, value);
        } else if (value < midvalue){// 向左递归
            return binarySearch2(arr, left, mid - 1, value);
        }else {
            /* 思路分析
			 * 1. 在找到mid 索引值，不要马上返回
			 * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
			 * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
			 * 4. 将Arraylist返回
            */
            ArrayList<Integer> resIndexlist = new ArrayList<Integer>();
            //向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            int temp = mid - 1;
            //退出
            while (temp >= 0 && arr[temp] == value) {
                //否则，就temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp -= 1; //temp左移
            }
            resIndexlist.add(mid);  //

            //向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            temp = mid + 1;
            //退出
            while (temp <= arr.length - 1 && arr[temp] == value) {
                //否则，就temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp += 1; //temp右移
            }

            return resIndexlist;
        }
    }
}
