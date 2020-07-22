package com.itheima;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo03 {
    public static void main(String[] args) {
        List<Student> l = new ArrayList<Student>();

        Student s1 = new Student("wangjie", 12);
        Student s2 = new Student("liujing", 12);

        l.add(s1);
        l.add(s2);

        // 使用迭代器进行遍历
        Iterator<Student> it = l.iterator();
        while (it.hasNext()){
            Student s = it.next();
            System.out.println(s.getName()+","+s.getAge());
        }
        // set/get 方法遍历
        for (int i = 0; i<l.size(); i++){
            Student s = l.get(i);
            System.out.println(s.getName()+","+s.getAge());
        }
    }
}
