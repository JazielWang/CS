package com.itheima_09;

public class InterImpl implements Inter{

    public InterImpl(){
        super();
    }

    @Override
    public void method() {
        System.out.println("method");
    }

    @Override
    public void show() {
        System.out.println("show");
    }
}
