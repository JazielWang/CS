package com.BinarySearchNoRecursion;

/**
 * @
 * @date 2020/9/11 - 8:35
 */
public class BinarySearchNoRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 63, 23, 52, 3};
        int i = binarySearch(23, arr);
        System.out.println("index=" + i);
    }

    /**
     * 不使用递归的二分查找
     * @param target 要查找的目标
     * @param arr 查找的数组
     * @return 返回要查找目标的下标
     */
    public static int binarySearch(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {//说明继续查找
            int mid = (right + left) / 2;
            //找到就返回下标
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {//如果 arr[mid] 比目标小，就向左查找
                right = mid - 1;
            } else {//如果 arr[mid] 比目标大，就向右查找
                left = mid + 1;
            }
        }
        return -1;
    }
}
