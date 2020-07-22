package com.itheima;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
    list 集合：有序，可重复
*/
public class ListDemo01 {
    public static void main(String[] args) {
        // 创建集合对象
        List<String> li = new ArrayList<String>();

        li.add("hello");
        li.add("world");
        li.add("java");
        li.add("world");

//        System.out.println(li);
        Iterator<String> it = li.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
    }
}
