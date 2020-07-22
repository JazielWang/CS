package com.itheima04;

import java.util.HashMap;
import java.util.Map;

/*
    Map集合概述
 */
public class MapDemo01 {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<String, String>();

        // V put(K key, V value);将指定的值与该映射中的指定键相关联
        m.put("wj01","林青霞");
        m.put("wj02","林青霞");
        m.put("wj03","张曼玉");
        m.put("wj01","王祖贤");

        System.out.println(m);
    }
}
