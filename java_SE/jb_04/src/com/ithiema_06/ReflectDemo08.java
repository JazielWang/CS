package com.ithiema_06;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
     练习：通过反射实现如下操作
        Student s = new Student();
        s.method1();
        s.method2("林青霞");
        String ss = s.method3("林青霞",30);
        System.out.println(ss);
        s.function();
 */
public class ReflectDemo08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("com.ithiema_06.Student");
        Constructor<?> con = c.getConstructor();
        Object o = con.newInstance();

        Method method1 = c.getMethod("method1");
        Method method2 = c.getMethod("method2", String.class);
        Method method3 = c.getMethod("method3", String.class, int.class);
        Method function = c.getDeclaredMethod("function");
        function.setAccessible(true);

        method1.invoke(o);
        method2.invoke(o, "林青霞");
        Object obj = method3.invoke(o, "林青霞", 23);
        System.out.println(obj);
        function.invoke(o);

    }
}
