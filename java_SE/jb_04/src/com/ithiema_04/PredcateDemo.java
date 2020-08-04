package com.ithiema_04;

import java.util.function.Predicate;

/*
    Predicate<T>：常用的四个方法
        boolean test​(T t)：对给定的参数进行判断(判断逻辑由Lambda表达式实现)，返回一个布尔值
        default Predicate<T> negate​()：返回一个逻辑的否定，对应逻辑非
        Predicate<T>接口通常用于判断参数是否满足指定的条件
 */
public class PredcateDemo {
    public static void main(String[] args) {
        /*boolean b1 = checkString("hello", (String s) -> {
            return s.length() > 8;
        });
        System.out.println(b1);
        boolean b2 = checkString("helloworld", (String s) -> {
            return s.length() > 8;
        });
        System.out.println(b2);*/
        boolean b1 = checkString("hello", s -> s.length() > 8);
        boolean b2 = checkString("hellowrold", s -> s.length() > 8);
        System.out.println(b1);
        System.out.println(b2);
        boolean b3 = checkString("hello", s -> s.length() > 8, s -> s.length() < 15);
        boolean b4 = checkString("helloworld", s -> s.length() > 8, s -> s.length() < 15);
        System.out.println(b3);
        System.out.println(b4);
    }

    private static boolean checkString(String s, Predicate<String> pre) {
//        return pre.test(s);
        return pre.negate().test(s);
    }

    private static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
//        return pre1.and(pre2).test(s);
        return pre1.or(pre2).test(s);
    }
}
