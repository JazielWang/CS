package com.ithiema_06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
    练习2：通过配置文件运行类中的方法
 */
public class ReflectTest02 {
    public static void main(String[] args) throws ClassNotFoundException, IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Student s = new Student();
//        s.study();

//        Teacher t = new Teacher();
//        t.teach();

        /*
            class.txt
            className=xxx
            methodName=xxx
         */

        //加载数据
        Properties prop = new Properties();
        FileReader fr = new FileReader("Class.txt");
        prop.load(fr);
        fr.close();

        String className = prop.getProperty("ClassName");
        String methodName = prop.getProperty("MethodName");

        Class<?> c = Class.forName(className);
        Constructor<?> con = c.getConstructor();
        Method method = c.getMethod(methodName);
        method.invoke(con);
    }
}
