package com.ItHeima_javabase_06;

import java.util.ArrayList;

public class ArrayListDemo_01 {
    public static void main(String[] args) {

        // public ArrayList : 构建一个空的集合对象
        ArrayList<String> array = new ArrayList<String>();

        // pulic boolean add(E e): 将指定的元素追加到此集合的末尾
        array.add("hello");
        array.add("world");
        // public void add(int, E element): 此集合中的指定位置插入指定元素
        array.add(1, "wangjie" );

        // IndexOutOfBoundsException:
        // array.add(4, "liujing");

        System.out.println("array:" + array);
    }
}
