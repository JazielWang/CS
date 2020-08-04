package com.ithiema_06;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectTest01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> al = new ArrayList<>();

        Class<? extends ArrayList> c = al.getClass();
        Method add = c.getMethod("add", Object.class);
        add.invoke(al,"liujing");
        add.invoke(al,"java");

        System.out.println(al);

    }
}
