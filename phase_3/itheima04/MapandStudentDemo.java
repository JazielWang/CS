package com.itheima04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapandStudentDemo {
    public static void main(String[] args) {
        HashMap<String, Student> hm = new HashMap<>();

        Student s1 = new Student("wangjie", 12);
        Student s2 = new Student("liujing", 12);
        Student s3 = new Student("xiulin", 12);

        hm.put("dl001", s1);
        hm.put("dl002", s2);
        hm.put("dl003", s3);

        // 方法1
        Set<String> strings = hm.keySet();
        for (String s : strings) {
            System.out.println(s + "," + hm.get(s).getName() + "," + hm.get(s).getAge());
        }
        System.out.println("-------------------");
        // 方法2
        Set<Map.Entry<String, Student>> entries = hm.entrySet();
        for (Map.Entry<String, Student> me : entries) {
            String key = me.getKey();
            Student s = me.getValue();
            System.out.println(key + "," + s.getName() + "," + s.getAge());
        }
    }
}
