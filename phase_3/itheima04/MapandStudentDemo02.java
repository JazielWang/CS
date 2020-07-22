package com.itheima04;

import java.util.HashMap;
import java.util.Set;

public class MapandStudentDemo02 {
    public static void main(String[] args) {
        HashMap<Student, String> hm = new HashMap<Student, String>();

        Student s1 = new Student("wangjie", 12);
        Student s2 = new Student("liujing", 12);
        Student s3 = new Student("xiulin", 12);
        Student s4 = new Student("liujing", 12);

        hm.put(s1, "西安");
        hm.put(s2, "武汉");
        hm.put(s3, "郑州");
        hm.put(s4, "北京");

        Set<Student> students = hm.keySet();
        for (Student key : students) {
            String value = hm.get(key);
            System.out.println(key.getName() + "," + key.getAge() + "," + value);
        }

    }
}
