package com.Search;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {12, 78, 92, 45, 89, 122};
        int value = 89;
        int i = seqSearch(arr, value);
        System.out.println("寻找的数字" + value + "在数组中的" + i + "号位置");
    }

    private static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
