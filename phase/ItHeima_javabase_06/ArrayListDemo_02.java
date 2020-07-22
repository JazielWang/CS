package com.ItHeima_javabase_06;

import java.util.ArrayList;

public class ArrayListDemo_02 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();

        array.add("hello");
        array.add("world");
        array.add("java");
        array.add("wosil");

        // public boolean remove(oject, o):删除指定的元素，返回删除是否成功
        System.out.println(array.remove("world"));
        System.out.println(array.remove("javaee"));

        // public E remove(int index):删除指定索引处的元素，返回别删除元素
        System.out.println(array.remove(1));

        // public E set(int index, E element):修改指定索引处的元素，返回被修改的元素
        System.out.println(array.set(0, "wangjie" ));

        //pulic E get(int index):返回指定索引处的元素
        System.out.println(array.get(0));

        // puclic size():返回之和中元素的个数
        System.out.println(array.size());

        System.out.println("array: " + array);

    }
}
