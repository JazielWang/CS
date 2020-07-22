package com.ItHeima_javabase_09;

public class ZiDemo extends FuDemo {

    public ZiDemo(){
//        super();
        super(21);
        System.out.println("Zi中无参构造方法被调用");
    }

    public ZiDemo(int age){
        super();
//        super(45);
        System.out.println("Zi中带参构造方法被调用");
    }
}
