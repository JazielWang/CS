package com.Tree;

/**
 * @
 * @date 2020/9/3 - 13:43
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrBinaryTree abt = new ArrBinaryTree(arr);
        abt.preOrder();
    }
}

class ArrBinaryTree {
    private static int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    public static void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("the tree is empty");
        }
        // 向左递归
        System.out.println(arr[index]);
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        // 向右递归
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }
}