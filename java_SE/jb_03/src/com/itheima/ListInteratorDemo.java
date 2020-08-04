package com.itheima;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListInteratorDemo {
    public static void main(String[] args) {
        // 创建集合对象
        List<String> li = new ArrayList<String>();

        li.add("hello");
        li.add("world");
        li.add("java");
        li.add("world");

        ListIterator<String> sit = li.listIterator();
        // 正向遍历
        /*while (sit.hasNext()) {
            String s = sit.next();
            System.out.println(s);
        }*/
        System.out.println("-----------");
        // 逆向遍历
        /*while (sit.hasPrevious()) {
            String s = sit.previous();
            System.out.println(s);
        }*/
        // 获取列表迭代器
        while (sit.hasNext()){
            String s = sit.next();
            if (s.equals("world")){
                sit.add("javaee");
            }
        }

        System.out.println(li);
    }
}
