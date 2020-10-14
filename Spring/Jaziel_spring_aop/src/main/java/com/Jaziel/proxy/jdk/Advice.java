package com.Jaziel.proxy.jdk;

/**
 * @author 王杰
 * @time 2020/9/29 14:59
 */
public class Advice {
    public void before(){
        System.out.println("前置增强..");
    }
    public void after(){
        System.out.println("后置增强..");
    }
}
