package com.itheima03;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ArgsDemo02 {
    public static void main(String[] args) {
        // Arrays工具类中有一个静态方法：
        //      public static <T> List<T> asList(T... a),返回指定数组支持的固定大小的列表
        List<String> list = Arrays.asList("hello", "world", "java");

//        list.add("javaee");//UnsupportedOperationException
//        list.remove("world");//UnsupportedOperationException
        list.set(1, "javaee");

        System.out.println(list);

        //public static <E> List<E> of​(E... elements)：返回包含任意数量元素的不可变列表
        List<String> list2 = List.of("hello", "world", "java", "world");

//        list2.add("javaee");//UnsupportedOperationException
//        list2.remove("java");//UnsupportedOperationException
//        list2.set(1,"javaee");//UnsupportedOperationException

        System.out.println(list2);

        //public static <E> Set<E> of​(E... elements) ：返回一个包含任意数量元素的不可变集合
//        Set<String> set = Set.of("hello", "world", "java","world"); //IllegalArgumentException
        Set<String> set = Set.of("hello", "world", "java");

//        set.add("javaee");//UnsupportedOperationException
//        set.remove("world");//UnsupportedOperationException

        System.out.println(set);
    }
}
