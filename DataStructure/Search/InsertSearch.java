package com.Search;

import java.util.Arrays;

public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        int i = insertSearch(arr, 0, arr.length - 1, 0);
        System.out.println(i);
    }

    //说明：插值查找算法，也要求数组是有序的
    /**
     *
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param value 查找值
     * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
     */
    public static int insertSearch(int[] arr, int left, int right, int value) {
        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }
        // 求出mid, 自适应
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midvalue = arr[mid];
        if (value > midvalue) {
            return insertSearch(arr, mid + 1, right, value);
        } else if (value < midvalue) {
            return insertSearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }
}
