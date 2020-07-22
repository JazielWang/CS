package com.ItHeima_javabase;

//利于现有的包，进行数据输入
import java.util.Scanner;

public class InputDemo {
    public static void main(String[] args){
        //创建对象
        Scanner sc = new Scanner(System.in);
        //接收数据
        int x = sc.nextInt();
        //输出数据
        System.out.println("x:" + x);

        System.out.println("请输入第一个合唱的身高：");
        int mk1 = sc.nextInt();
        System.out.println("请输入第一个合唱的身高：");
        int mk2 = sc.nextInt();
        System.out.println("请输入第一个合唱的身高：");
        int mk3 = sc.nextInt();
        int tall1 = mk1 > mk2 ? mk1 : mk2;
        int tall = tall1 > mk3 ? tall1 : mk3;
        System.out.println("这三个合唱中最高的人是:" + tall + "cm");
    }
}
