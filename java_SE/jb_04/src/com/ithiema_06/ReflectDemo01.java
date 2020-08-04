package com.ithiema_06;

/*
    三种方式获取Class对象
        1:使用类的class属性来获取该类对应的Class对象。举例：Student.class将会返回Student类对应的Class对象
        2:调用对象的getClass()方法，返回该对象所属类对应的Class对象
            该方法是Object类中的方法，所有的Java对象都可以调用该方法
        3:使用Class类中的静态方法forName(String className)，该方法需要传入字符串参数，该字符串参数的值是某个类的全路径，也就是完整包名的路径
 */
public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1:使用类的class属性来获取该类对应的Class对象。举例：Student.class将会返回Student类对应的Class对象
        Class<Student> c1 = Student.class;
        System.out.println(c1);

        Class<Student> c2 = Student.class;
        System.out.println(c1 == c2);

        //2:调用对象的getClass()方法，返回该对象所属类对应的Class对象
        Student s = new Student();
        Class<? extends Student> c3 = s.getClass();
        System.out.println(c1 == c3);

        //3:使用Class类中的静态方法forName(String className)，该方法需要传入字符串参数，该字符串参数的值是某个类的全路径，也就是完整包名的路径
        Class<?> c4 = Class.forName("com.ithiema_06.Student");
        System.out.println(c1 == c4);
    }
}
