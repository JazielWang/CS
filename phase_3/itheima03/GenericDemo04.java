package com.itheima03;

import java.util.ArrayList;
import java.util.List;

/*
    类型通配符
 */
public class GenericDemo04 {
    public static void main(String[] args) {
        // List<?>:未知类型的List
        List<?> l1 = new ArrayList<Object>();
        List<?> l2 = new ArrayList<Number>();
        List<?> l3 = new ArrayList<Integer>();
        System.out.println("-------------------");

        // 类型统配符是上限：List<? extends 类型>
//        List<? extends Number> l4 = new ArrayList<Object>();
        List<? extends Number> l5 = new ArrayList<Number>();
        List<? extends Number> l6 = new ArrayList<Integer>();

        // 类型通配符下限： List<? super 类型>
        List<? super Number> l7 = new ArrayList<Object>();
        List<? super Number> L8 = new ArrayList<Number>();
//        List<? super Number> L9 = new ArrayList<Integer>();
    }
}
