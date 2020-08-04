package com.ItHeima_javabase_04;

public class StudentDemo3 {
    public static void main(String[] args) {
        // 使用无参构造方法构建对象后使用set（）赋值
        Student3 s1 = new Student3();
        s1.setName("Tom");
        s1.setAge(16);
        s1.show();

        // 使用带参方法直接创建带有属性值的对象
        Student3 s2 = new Student3("tome", 33);
        s2.show();
    }

}
