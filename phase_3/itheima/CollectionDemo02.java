package com.itheima;

import java.util.ArrayList;
import java.util.Collection;

//  alt + 7 :打开一个敞口，能够看到一些信息

public class CollectionDemo02 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();

        c.add("hello, world!");
        c.add("java");
//        System.out.println(c.add("java"));

        System.out.println(c.remove("java"));
        System.out.println(c.remove("hello"));

//        c.clear();

        System.out.println(c.contains("hello, world!"));

        System.out.println(c.isEmpty());

        System.out.println(c.size());

        System.out.println(c);


    }
}
