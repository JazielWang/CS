package com.itheima08;
/*
    Properties作为Map集合的使用
 */
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo01 {
    public static void main(String[] args) {
        Properties pps = new Properties();

        pps.put("itheima001", "王杰");
        pps.put("itheima002", "刘晶");
        pps.put("itheima003", "王敬");

        Set<Object> objects = pps.keySet();
        for (Object o : objects) {
            Object o1 = pps.get(o);
            System.out.println(o + "," + o1);
        }
    }
}
