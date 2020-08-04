package com.ItHeima_javabase_010;

public class ZiDemo extends FuDemo {

    public void method(){
        System.out.println("Zi中method()方法被调用");
    }

    public void show(){
        super.show();
        System.out.println("Zi中show()方法被调用");
    }
}
