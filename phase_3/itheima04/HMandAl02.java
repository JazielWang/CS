package com.itheima04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HMandAl02 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        ArrayList<String> al1 = new ArrayList<>();
        al1.add("火影");
        al1.add("死神");
        al1.add("妖尾");

        ArrayList<String> al2 = new ArrayList<>();
        al2.add("路飞");
        al2.add("鸣人");
        al1.add("我爱罗");

        ArrayList<String> al3 = new ArrayList<>();
        al3.add("xx");
        al3.add("oo");
        al3.add("yy");

        hm.put("动漫", al1);
        hm.put("动漫人物", al2);
        hm.put("字母", al3);

        Set<String> strings = hm.keySet();
        for (String s : strings) {
            ArrayList<String> arrayList = hm.get(s);
            for (String s2 : arrayList) {
                System.out.println(s + "," + s2);
            }
        }

    }
}
