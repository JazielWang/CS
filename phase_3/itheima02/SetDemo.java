package com.itheima02;

import java.util.HashSet;
import java.util.Set;

/*
    set 集合的特点：
        不包含重复元素的集合；
        没有带索引的方法，所以不能使用普通for循环遍历
     HashSet：对集合的迭代循序不坐任何保证
 */
public class SetDemo {
    public static void main(String[] args) {
        // 常见结合对象
        Set<String> s = new HashSet<String>();
        s.add("hello");
        s.add("world");
        s.add("java");
        // 不重复
        s.add("java");

        for (String t : s) {
            System.out.println(t);
        }
    }
}
