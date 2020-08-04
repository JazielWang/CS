package com.ithiema_02;

public interface MyInterface {
    void show1();
    void show2();
//    void show3();

    //    public default void show3() {
//        System.out.println("show3");
//    }
    public default void show3(){
        System.out.println("show3");
    }
}
