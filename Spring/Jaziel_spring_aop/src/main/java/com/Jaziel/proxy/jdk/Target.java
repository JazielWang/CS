package com.Jaziel.proxy.jdk;

/**
 * @author 王杰
 * @time 2020/9/29 14:58
 */
public class Target implements TargetInterface{
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
