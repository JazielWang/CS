package com.Greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @
 * @date 2020/9/12 - 17:02
 */
public class Greedy {
    public static void main(String[] args) {
        //创建广播电台,放入到Map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");


        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建ArrayList, 存放选择的电台集合
        HashSet<String> select = new HashSet<>();
        //定义一个临时的集合， 在遍历的过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempKey = new HashSet<>();
        //定义给maxKey ， 保存在一次遍历过程中，能够覆盖最大未覆盖的地区对应的电台的key
        //如果maxKey 不为null , 则会加入到 selects
        String maxKey = null;
        int maxTemp;
        while (allAreas.size() != 0) {
            //每进行一次while,需要
            maxKey = null;
            maxTemp = 0;
            //遍历 broadcasts, 取出对应key
            for (String key : broadcasts.keySet()) {
                //每进行一次for
                tempKey.clear();
                HashSet<String> areas = broadcasts.get(key);
                //当前这个key能够覆盖的地区
                //求出 tempSet 和 allAreas 集合的交集, 交集会赋给 tempSet
                tempKey.addAll(areas);
                tempKey.retainAll(allAreas);
                //如果当前这个集合包含的覆盖地区的数量，比maxKey指向的集合地区还多,就需要重置maxKey
                // tempSet.size() >broadcasts.get(maxKey).size()) 体现出贪心算法的特点,每次都选择最优的
                if (tempKey.size() > 0 &&
                        (maxKey == null || tempKey.size() > maxTemp)) {
                    maxKey = key;
                    maxTemp = tempKey.size();
                }
            }
            //maxKey != null, 就应该将maxKey 加入selects
            if (maxKey != null) {
                select.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区，从 allAreas 去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println(select);
    }
}
