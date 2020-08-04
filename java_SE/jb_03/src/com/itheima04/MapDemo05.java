package com.itheima04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo05 {
    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap<Integer, String>();

        m.put(1, "王祖贤");
        m.put(2, "张曼玉");
        m.put(3, "林青霞");
        m.put(4, "貂蝉");
        m.put(5, "西施");
        m.put(6, "冬施");

        // 获取所有键值对对象的集合
        Set<Map.Entry<Integer, String>> entries = m.entrySet();
        // 遍历键值对对象的集合，得到每一个键值对对象
        for (Map.Entry<Integer, String> me: entries){
            // 根据键值对对象获取键和值
            System.out.println(me.getKey()+","+me.getValue());
        }
    }
}
