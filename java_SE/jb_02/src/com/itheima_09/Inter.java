package com.itheima_09;

public interface Inter {

    public int num = 10;
    public final int num2 = 20;
//    public static final int num3 = 30;
    // 接口中的变量默认是静态常量
    int num3 = 30;

//    public Inter(){}

//    public void show(){}
    public abstract void method();
    void show();
}
