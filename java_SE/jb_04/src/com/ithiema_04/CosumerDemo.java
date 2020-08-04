package com.ithiema_04;

import java.util.function.Consumer;

/*
    Consumer<T>：包含两个方法
        void accept​(T t)：对给定的参数执行此操作
        default Consumer<T> andThen​(Consumer after)：返回一个组合的 Consumer，依次执行此操作，然后执行 after操作
        Consumer<T>接口也被称为消费型接口，它消费的数据的数据类型由泛型指定
 */
public class CosumerDemo {
    public static void main(String[] args) {
        /*operatorString("刘晶",(String s)->{
            System.out.println(s);
        });*/
        operatorString("刘晶", s -> System.out.println(s));
        operatorString("刘晶", s -> System.out.println(new StringBuilder(s).reverse().toString()));

        operatorString("刘晶", s -> System.out.println(s), s -> System.out.println(new StringBuilder(s).reverse().toString()));
    }

    //定义一个方法，用不同的方式消费同一个字符串数据两次
    private static void operatorString(String s, Consumer<String> con) {
        con.accept(s);
    }

    //定义一个方法，消费一个字符串数据
    private static void operatorString(String s, Consumer<String> con1, Consumer<String> con2) {
        /*con1.accept(s);
        con2.accept(s);*/
        con1.andThen(con2).accept(s);
    }
}
