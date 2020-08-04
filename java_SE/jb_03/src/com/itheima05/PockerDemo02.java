package com.itheima05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PockerDemo02 {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();

        ArrayList<Integer> arr = new ArrayList<>();

        String[] color = {"方片", "红桃", "梅花", "黑桃"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int index = 0;

        for (String colo : color) {
            for (String num : number) {
                hm.put(index, colo + num);
                arr.add(index);
                index++;
            }
        }
        hm.put(index, "joker");
        arr.add(index);
        index++;
        hm.put(index, "JOKER");
        arr.add(index);

        Collections.shuffle(arr);
        TreeSet<Integer> lj = new TreeSet<>();
        TreeSet<Integer> wj = new TreeSet<>();
        TreeSet<Integer> dqy = new TreeSet<>();
        TreeSet<Integer> dp = new TreeSet<>();

        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i);
            if (i >= arr.size() - 3) {
                dp.add(x);
            } else if (i % 3 == 0) {
                lj.add(x);
            } else if (i % 3 == 1) {
                wj.add(x);
            } else if (i % 3 == 2) {
                dqy.add(x);
            }
        }

        lookpoker("wj", wj, hm);
        lookpoker("lj", lj, hm);
        lookpoker("dqy", dqy, hm);
        lookpoker("dp", dp, hm);

    }


    public static void lookpoker(String name, TreeSet<Integer> array, HashMap<Integer, String> hm) {
        System.out.println(name + "的牌是：");
        for (Integer s : array) {
            System.out.print(hm.get(s) + " ");
        }
        System.out.println();
    }
}
