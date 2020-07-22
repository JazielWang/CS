package com.itheima02;

import java.util.TreeSet;
import java.util.Comparator;

public class TreeSetDemo04 {
    public static void main(String[] args) {
        TreeSet<Student2> ts = new TreeSet<>(new Comparator<Student2>() {
            @Override
            public int compare(Student2 s2, Student2 s1) {
                int num = (s1.getChinesescore()+s1.getMathscore())-(s2.getChinesescore()+s2.getMathscore());
                int num2 = num==0?s1.getName().compareTo(s2.getName()):num;
                int num3 = num2==0?s1.getChinesescore()-s2.getChinesescore():num2;
                return num3;
            }
        });

        Student2 s1 = new Student2("liujing", 89,88);
        Student2 s2 = new Student2("wangjie", 99,68);
        Student2 s3 = new Student2("dangqingyuan", 56,78);
        Student2 s4 = new Student2("yukai", 87,99);

        Student2 s5 = new Student2("yukai", 86,100);


        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);

        for (Student2 s : ts){
            System.out.println(s.getName()+","+s.getMathscore()+","+s.getChinesescore());
        }

    }
}
