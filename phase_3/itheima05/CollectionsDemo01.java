package com.itheima05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo01 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();

        l.add(45);
        l.add(26);
        l.add(49);
        l.add(65);

        // public static <T extends Comparable<? super T>> void sort​(List<T> list)：将指定的列表按升序排序
//        Collections.sort(l);

        //public static void reverse​(List<?> list)：反转指定列表中元素的顺序
//        Collections.reverse(l);

        //public static void shuffle​(List<?> list)：使用默认的随机源随机排列指定的列表
        Collections.shuffle(l);

        System.out.println(l);

    }
}
