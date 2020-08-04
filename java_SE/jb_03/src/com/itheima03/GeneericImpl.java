package com.itheima03;

public class GeneericImpl<T> implements Generic03<T>{

    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
