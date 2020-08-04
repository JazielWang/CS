package com.ithiema_06;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
    练习：通过反射实现如下操作
        Student s = new Student();
        s.name = "林青霞";
        s.age = 30;
        s.address = "西安";
        System.out.println(s);
 */
public class ReflectDemo06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> c = Class.forName("com.ithiema_06.Student");
        Constructor<?> con = c.getConstructor();
        Object o = con.newInstance();

        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        Field age = c.getDeclaredField("age");
        Field address = c.getField("address");

        name.set(o,"林青霞");
        age.set(o,30);
        address.set(o,"西安");

        System.out.println(o);
    }
}
