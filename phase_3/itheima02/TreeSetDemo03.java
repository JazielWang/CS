package com.itheima02;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo03 {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // this.age - s.age
                //s1,s2
                int num = s1.getAge() - s2.getAge();
                int mum2 = num==0?s1.getName().compareTo(s2.getName()):num;
                return mum2;
            }
        });
        Student s1 = new Student("xishi", 12);
        Student s2 = new Student("yangyuhuan", 16);
        Student s3 = new Student("diaochan", 11);
        Student s4 = new Student("dushiniang", 19);

        Student s5 = new Student("liujing", 19);
        Student s6 = new Student("liujing", 19);


        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        for (Student s : ts) {
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}
