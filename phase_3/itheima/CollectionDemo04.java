package com.itheima;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo04 {
    public static void main(String[] args) {
        Collection<Student> c = new ArrayList<Student>();

        Student s = new Student();
        s.setName("xiaoming");
        s.setAge(12);
        Student s2 = new Student("xiaohong", 13);

        c.add(s);
        c.add(s2);

        Iterator<Student> it = c.iterator();
        while (it.hasNext()){
            Student s3 = it.next();
            System.out.println(s3.getName()+","+s3.getAge());
        }
    }

}
