package com.ithiema_06;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
    反射获取成员变量并使用
 */
public class ReflectDemo05 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("com.ithiema_06.Student");
        //Field[] getFields​() 返回一个包含 Field对象的数组， Field对象反映由该 Class对象表示的类或接口的所有可访问的公共字段
        //Field[] getDeclaredFields​() 返回一个 Field对象的数组，反映了由该 Class对象表示的类或接口声明的所有字段
//        Field[] fields = c.getFields();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("----------------");

        //Field getField​(String name) 返回一个 Field对象，该对象反映由该 Class对象表示的类或接口的指定公共成员字段
        //Field getDeclaredField​(String name) 返回一个 Field对象，该对象反映由该 Class对象表示的类或接口的指定声明字段
        Field declaredField = c.getField("address");

        Constructor<?> cons = c.getConstructor();
        Object o = cons.newInstance();

        //Field提供有关类或接口的单个字段的信息和动态访问
        //void set​(Object obj, Object value) 将指定的对象参数中由此 Field对象表示的字段设置为指定的新值
        declaredField.set(o,"西安");
        System.out.println(o);

//        Student s = new Student();
//        s.address = "西安";
//        System.out.println(s);
    }
}
