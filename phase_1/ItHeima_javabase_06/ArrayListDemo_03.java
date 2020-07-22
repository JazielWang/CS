package com.ItHeima_javabase_06;

import java.util.ArrayList;

// 案例：存储字符串并且遍历

public class ArrayListDemo_03 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();
        array.add("hello");
        array.add("world");
        array.add("hello");
        array.add("java");

        System.out.println("array:"  + array);

        for (int i =0; i < array.size(); i++){
            String s = array.get(i);
            System.out.println(s);
        }
    }
}
