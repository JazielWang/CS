package com.ItHeima_javabase_014;

public class PersonDemo {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setName("朱丽萍");
        t1.setAge(30);
        System.out.println(t1.getName() + "," + t1.getAge());
        t1.teach();

        Teacher t2 = new Teacher("党庆媛", 23);
        System.out.println(t2.getName() + "," + t2.getAge());
        t2.teach();

        Student s1 = new Student();
        s1.setName("**");
        s1.setAge(23);
        System.out.println(s1.getName() + "," + s1.getAge());
        s1.fuck();

        Student s2 = new Student("刘晶", 23);
        System.out.println(s2.getName() + "," + s2.getAge());
        s2.fuck();

    }
}
