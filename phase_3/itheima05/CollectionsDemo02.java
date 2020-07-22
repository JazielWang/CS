package com.itheima05;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsDemo02 {
    public static void main(String[] args) {
        ArrayList<Student> al = new ArrayList<>();
        Student s1 = new Student("liujing", 12);
        Student s2 = new Student("wangjie", 99);
        Student s3 = new Student("dangqingyuan", 56);
        Student s4 = new Student("yukai", 87);
        Student s5 = new Student("dukai", 87);


        al.add(s1);
        al.add(s2);
        al.add(s3);
        al.add(s4);
        al.add(s5);

//        Collections.sort(al);

        Collections.sort(al, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num = s1.getAge() - s2.getAge();
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num2;
            }
        });
        for (Student s : al){
            System.out.println(s.getName()+","+s.getAge());
        }
    }
}
