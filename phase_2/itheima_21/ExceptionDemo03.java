package com.itheima_21;

/*
    try...catch 处理异常
 */
public class ExceptionDemo03 {
    public static void main(String[] args) {
        System.out.println("start");
        method();
        System.out.println("end");
    }

    public static void method() {
        try {
            int[] arr = {23, 25, 252};
//        System.out.println(arr[1]);
            System.out.println(arr[3]);//new ArrayIndexOutOfBoundsException()
        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("你访问的数组索引不存在");
            e.printStackTrace();
            // Index 3 out of bounds for length 3
//            System.out.println(e.getMessage());

//            System.out.println(e.toString());
        }
    }
}
