package com.itheima03;

import org.ietf.jgss.GSSName;

public class GenericDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("网二级");
        System.out.println(s.getName());

        Teacher t = new Teacher();
        t.setAge(12);
        System.out.println(t.getAge());
        System.out.println("-----------");

        Generic<String> g1 = new Generic<>();
        g1.setT("王杰");
        System.out.println(g1.getT());
        Generic<Integer> g2 = new Generic<>();
        g2.setT(12);
        System.out.println(g2.getT());
        Generic<Boolean> g3 = new Generic<>();
        g3.setT(true);
        System.out.println(g3.getT());
    }
}
