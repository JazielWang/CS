package com.ithiema_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
    定义一个类(ComparatorDemo)，在类中提供两个方法
            一个方法是：Comparator<String> getComparator()   方法返回值Comparator是一个函数式接口
            一个方法是主方法，在主方法中调用getComparator方法
*/
public class ComparatorDemo {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();

        a.add("b");
        a.add("aa");
        a.add("cccd");
        a.add("ddd");
        System.out.println("排序前：" + a);
//        Collections.sort(a);
        Collections.sort(a, getComparator());
        System.out.println("排序后：" + a);
    }

    private static Comparator<String> getComparator() {
        //匿名内部类的方式实现
        /*Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };
        return com;*/

        /*return new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };*/

        return (s1, s2) -> s1.length() - s2.length();
    }
}
