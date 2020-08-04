package com.ItHeima_javabase_04;

import javax.xml.namespace.QName;

public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student();

        // 使用 set 方法给成员赋值
        s.setName("Tom");
        s.setAge(15);
        s.show();

        // 使用 get 方法输出
        System.out.println(s.getName() + "---" + s.getName());
    }
}
