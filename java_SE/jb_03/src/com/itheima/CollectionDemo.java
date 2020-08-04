package com.itheima;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {

        // 创建Collection集合对象
        Collection<String> c = new ArrayList<String>();

        // 添加元素： boolean add(E e)
        c.add("hello");
        c.add("world");

        // 输出集合对象
        System.out.println(c);
    }
}
