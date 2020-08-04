package com.itheima;

import java.util.ArrayList;
import java.util.List;

public class ForDemo {
    public static void main(String[] args) {
        int[] arr = {12, 42, 25};
        for (int i : arr) {
            System.out.println(i);
        }

        String[] strArray = {"hello", "world", "java"};
        for (String s : strArray) {
            System.out.println(s);
        }

        List<String> list = new ArrayList<String>();
        list.add("javaee");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
