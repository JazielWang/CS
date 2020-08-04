package com.itheima08;

import java.util.Properties;
import java.util.Set;

/*
    Properties作为集合的特有方法：
        Object setProperty(String key, String value)：设置集合的键和值，都是String类型，底层调用Hashtable方法put
        String getProperty(String key)：使用此属性列表中指定的键搜索属性
        Set<String> stringPropertyNames()：从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串
 */
public class PropertiesDemo02 {
    public static void main(String[] args) {
        Properties pps = new Properties();

        pps.setProperty("itheima001", "王杰");
        pps.setProperty("itheima002", "王杰");
        pps.setProperty("itheima003", "王杰");

        System.out.println(pps.getProperty("itheima001"));
        System.out.println(pps.getProperty("itheima0011"));


//        System.out.println(pps);

        Set<String> key = pps.stringPropertyNames();
        for (String s : key) {
            String property = pps.getProperty(s);
            System.out.println(s + "," + property);
        }
    }
}
