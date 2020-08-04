package com.ItHeima_javabase_017;

public class StudentDemo {
    public static void main(String[] args) {

        Student.university = "qingdao";

        Student s = new Student();
        s.name = "wangjie";
        s.age = 23;
//        s.university = "qingdao";
        s.show();

        Student s2 = new Student();
        s.name = "liujing";
        s.age = 23;
//        s.university = "qingdao";
        s.show();
    }
}
