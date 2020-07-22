package com.itheima02;

import java.util.TreeSet;

/*
    treeSet 集合信息和特点
 */
public class TreeSetDemo01 {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(10);
        ts.add(60);
        ts.add(50);
        ts.add(10);
        ts.add(20);
        ts.add(80);
        ts.add(70);

        for (int i : ts) {
            System.out.println(i);
        }

    }
}
