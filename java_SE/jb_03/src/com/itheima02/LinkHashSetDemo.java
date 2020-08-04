package com.itheima02;

import java.util.LinkedHashSet;

public class LinkHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("world");
        lhs.add("world");
        lhs.add("hello");
        lhs.add("java");

        for (String s : lhs) {
            System.out.println(s);
        }
    }
}
