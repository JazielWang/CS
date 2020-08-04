package com.itheima;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListDemo06 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();

        al.add("hello");
        al.add("world");

        for (String s : al) {
            System.out.println(s);
        }

        LinkedList<String> ll = new LinkedList<String>();
        ll.add("hello");
        ll.add("java");
        for (String s : ll) {
            System.out.println(s);
        }
    }
}
