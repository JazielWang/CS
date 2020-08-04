package com.itheima02;
/*
       HashSet 案例
 */
import java.util.HashSet;
import java.util.function.DoubleToIntFunction;

public class HashSetDemo02 {
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<Student>();
        Student s1 = new Student("蕾姆", 18);
        Student s2 = new Student("提姆", 18);
        Student s3 = new Student("486", 18);
        Student s4 = new Student("486", 18);

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);

        for (Student s : hs) {
            System.out.println(s.getName() + "," + s.getAge());
        }


    }
}
