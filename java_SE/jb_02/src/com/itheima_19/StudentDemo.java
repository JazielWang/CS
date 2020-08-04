package com.itheima_19;

public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student("wangjei", 45);
        System.out.println(s);
        Student s2 = new Student("wangjei" ,45);

        System.out.println(s == s2);
        System.out.println(s.equals(s2));
    }
}
