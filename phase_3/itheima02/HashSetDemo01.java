package com.itheima02;

import java.util.HashSet;
/*
    HashSet 集合特点
 */
public class HashSetDemo01 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();

        hs.add("hello");
        hs.add("world");
        hs.add("java");
        hs.add("world");

        System.out.println(hs);

        for (String s : hs) {
            System.out.println(s);
        }
    }
}
