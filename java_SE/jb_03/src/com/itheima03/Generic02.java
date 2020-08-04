package com.itheima03;
/*
    泛型方法
 */
/*public class Generic02 {
    public void show(String s){
        System.out.println(s);
    }
    public void show(Integer i){
        System.out.println(i);
    }
    public void show(Boolean b){
        System.out.println(b);
    }
}*/
// 泛型方法的改进
public class Generic02{
    public <T> void show(T t){
        System.out.println(t);
    }
}
