package com.itheima04;

import java.util.HashMap;
import java.util.Map;

public class MapDemo02 {
    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap<Integer, String>();

        m.put(1,"王祖贤");
        m.put(2,"张曼玉");
        m.put(3,"林青霞");
        m.put(4,"貂蝉");
        m.put(5,"西施");
        m.put(6,"冬施");

        System.out.println(m.remove(4));
        System.out.println(m.remove(7));

//        m.clear();

        System.out.println(m.containsKey(6));
        System.out.println(m.containsKey(7));

        System.out.println(m.isEmpty());

        System.out.println(m.size());

        System.out.println(m);
    }
}
