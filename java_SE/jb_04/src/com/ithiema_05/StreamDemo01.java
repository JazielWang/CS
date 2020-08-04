package com.ithiema_05;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

/*
    需求：按照下面的要求完成集合的创建和遍历
        1:创建一个集合，存储多个字符串元素
        2:把集合中所有以"张"开头的元素存储到一个新的集合
        3:把"张"开头的集合中的长度为3的元素存储到一个新的集合
        4:遍历上一步得到的集合
 */
/*
    Stream<T> filter​(Predicate predicate)：用于对流中的数据进行过滤
    Predicate接口中的方法	boolean test​(T t)：对给定的参数进行判断，返回一个布尔值
 */
public class StreamDemo01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");
        ArrayList<String> zhanglist = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("张")) {
                zhanglist.add(s);
            }
        }
        ArrayList<String> three = new ArrayList<>();
        for (String s : zhanglist) {
            if (s.length() == 3) {
                three.add(s);
            }
        }
        for (String s : three) {
            System.out.println(s);
        }

        //Stream流来改进
//        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length()==3).forEach(s -> System.out.println(s));
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);

    }
}
