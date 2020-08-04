package com.itheima;

import java.util.ArrayList;
import java.util.List;

public class ListDemo02 {
    public static void main(String[] args) {
        // 创建集合对象
        List<String> li = new ArrayList<String>();

        li.add("hello");
        li.add("world");
        li.add("java");
        li.add("world");

        li.add(1, "javaee");

        System.out.println(li.remove(1));

        System.out.println(li.set(1,"javaee"));

        System.out.println(li.get(1));

        System.out.println(li);
        // 新的遍历集合
        for (int i = 0; i < li.size(); i++){
            String s =li.get(i);
            System.out.println(s);
        }
    }
}
