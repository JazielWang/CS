package com.itheima;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo04 {
    public static void main(String[] args) {
        // 创建集合对象
        List<String> li = new ArrayList<String>();

        li.add("hello");
        li.add("world");
        li.add("java");
        li.add("world");

        /*Iterator<String> it = li.iterator();
        while (it.hasNext()){
            String s = it.next();
            if (s.equals("world")){
                li.add("javaee");
            }
        }*/

        for (int i = 0; i < li.size(); i++){
            String s = li.get(i);
            if (s.equals("world")){
                li.add("javaee");
            }
        }
        // ConcurrentModificationException:并发修改异常
        System.out.println(li);
    }
}
