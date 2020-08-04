package com.itheima04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
//ArrayList集合存储HashMap集合元素并遍历
public class HMandAL01 {
    public static void main(String[] args) {
        ArrayList<HashMap<String, String>> a = new ArrayList<>();
        HashMap<String, String> m1 = new HashMap<>();
        m1.put("itheima001", "时间");
        m1.put("itheima002", "空间");
        m1.put("itheima003", "无畏");
        HashMap<String, String> m2 = new HashMap<>();
        m2.put("孙策", "小乔");
        m2.put("周瑜", "大乔");

        a.add(m1);
        a.add(m2);

        for (HashMap<String, String> map : a) {
            Set<String> strings = map.keySet();
            for (String st : strings) {
                String s = map.get(st);
                System.out.println(st + "," + s);
            }
        }
    }
}
