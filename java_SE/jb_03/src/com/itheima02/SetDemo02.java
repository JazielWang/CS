package com.itheima02;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo02 {
    public static void main(String[] args) {
//        Set<Integer> s = new HashSet<Integer>();//无序
        Set<Integer> s = new TreeSet<>();// 有序

        Random r = new Random();

        while (s.size() < 10) {
            int num = r.nextInt(20) + 1;
            s.add(num);
        }

        for (Integer i : s) {
            System.out.println(i);
        }
    }
}
