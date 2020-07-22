package com.ItHeima_javabase_06;

import java.util.ArrayList;

public class ArrayListDemo_04 {
    public static void main(String[] args) {
        ArrayList<StudentClass> array = new ArrayList<StudentClass>();


        StudentClass s1 = new StudentClass("xiaohong", 16);
        StudentClass s2 = new StudentClass();
        s2.setName("ximing");
        s2.setAge(16);
        StudentClass s3 = new StudentClass("daming", 23);

        array.add(s1);
        array.add(s2);
        array.add(s3);

        System.out.println(array);

        for (int i = 0; i < array.size(); i++){
            StudentClass s = array.get(i);
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}
