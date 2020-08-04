package com.itheima04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo04 {
    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap<Integer, String>();

        m.put(1, "王祖贤");
        m.put(2, "张曼玉");
        m.put(3, "林青霞");
        m.put(4, "貂蝉");
        m.put(5, "西施");
        m.put(6, "冬施");

        Set<Integer> i = m.keySet();
        for (Integer in : i) {
            System.out.println(in + "," + m.get(in));
        }
    }
}
