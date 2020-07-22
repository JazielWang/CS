package com.itheima05;

import java.util.ArrayList;
import java.util.Collections;

public class PokerDemo01 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();

        String[] color = {"方片","红桃","梅花","黑桃"};
        String[] number = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        for (String s : color){
            for (String s2 : number){
                array.add(s+s2);
            }
        }
        array.add("joker");
        array.add("JOKER");

        Collections.shuffle(array);

        ArrayList<String> sy = new ArrayList<String>();
        ArrayList<String> wj = new ArrayList<String>();
        ArrayList<String> dqy = new ArrayList<String>();
        ArrayList<String> ysm = new ArrayList<String>();

        for (int i = 0; i<array.size(); i++){
            String poker = array.get(i);
            if (i >= array.size() - 3){
                sy.add(poker);
            }else if(i % 3 ==0){
                wj.add(poker);
            }else if (i%3==1){
                dqy.add(poker);
            }else if (i%3==2){
                ysm.add(poker);
            }
        }

        lookpoker("王杰", wj);
        lookpoker("dqy",dqy);
        lookpoker("yam",ysm);
    }


    public static void lookpoker(String name, ArrayList<String> array){
        System.out.println(name + "的牌是：");
        for (String poker : array){
            System.out.print(poker+" ");
        }
        System.out.println();
    }
}
