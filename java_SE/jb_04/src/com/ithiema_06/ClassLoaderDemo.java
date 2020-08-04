package com.ithiema_06;
/*
    ClassLoader 中的两个方法
        static ClassLoader getSystemClassLoader​()：返回用于委派的系统类加载器
        ClassLoader getParent​()：返回父类加载器进行委派
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        //static ClassLoader getSystemClassLoader​()：返回用于委派的系统类加载器
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println(cl);//AppClassLoader

        //ClassLoader getParent​()：返回父类加载器进行委派
        ClassLoader c2 = cl.getParent();
        System.out.println(c2);//PlatformClassLoader

        ClassLoader c3 = c2.getParent();
        System.out.println(c3);//null
    }
}
