package com.itheima_11;

public class Demo {
    public static void main(String[] args) {
        // 创建对象
        PingpangStudent ppp = new PingpangStudent();
        ppp.setName("wanghao");
        ppp.setAge(30);
        System.out.println(ppp.getName()+","+ppp.getAge());
        ppp.eat();
        ppp.learn();
        ppp.English();

        
    }
}
