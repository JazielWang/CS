package com.ItHeima_javabase_3;

import org.w3c.dom.ls.LSOutput;

public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println("s1" + s1);

        s1.setAge(15);
        s1.name = "tom";
        s1.show();

        s1.study();
        s1.doHomework();

        Student s2 = s1;
        s2.name = "harry";
        s2.setAge(14);
        s1.show();
        s2.show();

        s2.study();
        s2.doHomework();
    }
}
