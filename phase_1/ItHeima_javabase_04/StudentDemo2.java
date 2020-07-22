package com.ItHeima_javabase_04;

/*
   构造方法的调用
*/

public class StudentDemo2 {
    public static void main(String[] args) {
        Student2 s = new Student2();
        s.show();

        Student2 s2 = new Student2("tom");
        s2.show();

        Student2 s3 = new Student2(26);
        s3.show();

        Student2 s4 = new Student2("tome", 36);
        s4.show();
    }
}
