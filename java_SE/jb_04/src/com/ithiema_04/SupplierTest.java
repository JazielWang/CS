package com.ithiema_04;

import java.util.function.Supplier;

/*
    定义一个类(SupplierTest)，在类中提供两个方法
            一个方法是：int getMax(Supplier<Integer> sup)   用于返回一个int数组中的最大值
            一个方法是主方法，在主方法中调用getMax方法
*/
public class SupplierTest {
    public static void main(String[] args) {
        //定义一个int数组
        int[] arr = {12, 89, 23, 25};

        int maxvalue = getMax(() -> {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        });

        System.out.println(maxvalue);
    }

    //返回一个int数组中的最大值
    private static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }
}
