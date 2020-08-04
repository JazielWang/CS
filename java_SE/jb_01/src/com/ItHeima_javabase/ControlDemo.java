package com.ItHeima_javabase;

import java.util.Scanner;

public class ControlDemo {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        //if语句格式 1
        System.out.println("start");
        int a = 10;
        int b = 20;
        //需求：判断a和b的值是否相等，如果相等，就在控制台输出：a=b
        if(a == b){
            System.out.println("a = b");
        }
        System.out.println("end");
        System.out.println("------------");


        //if语句格式 2
        System.out.println("start");
        int A = 10;
        int B = 20;
        if(a == b){
            System.out.println("a = b");
        }else {
            System.out.println("a != b");
        }
        System.out.println("end");
        System.out.println("------------");

        //if 案例
        int x = cs.nextInt();
        if(x % 2 == 0){
            System.out.println("这个数是偶数");
        }else{
            System.out.println("这个数是奇数");
        }
        System.out.println("------------");


        // if 语句的格式 3
        System.out.println("start");
        System.out.println("请输入一个星期数（1-7）：");
        int y = cs.nextInt();
        if(y > 7 | y <1){
            System.out.println("输入数据错误");
        }else if(y == 1){
            System.out.println("今天是星期一");
        }else if(y == 2){
            System.out.println("今天是星期二");
        }else if(y == 3){
            System.out.println("今天是星期三");
        }else if(y == 4){
            System.out.println("今天是星期四");
        }else if(y == 5){
            System.out.println("今天是星期五");
        }else{
            System.out.println("今天是周末，不上班");
        }
        System.out.println("------------");


        // switch 语句
        System.out.println("start");
        System.out.println("请输入一个星期数（1-3）：");
        int week = cs.nextInt();
        switch (week){
            case 1:
                System.out.println("今天是星期一");
                break;
            case 2:
                System.out.println("今天是星期二");
                break;
            case 3:
                System.out.println("今天是星期三");
                break;
            default:
                System.out.println("输入数据错误");
                break;
        }
        System.out.println("------------");


        //switch 语句 实例
        //case 穿透
        System.out.println("start");
        System.out.println("请输入一个月份：1-3（春季），4-6（夏季），7-9（秋季)，10-12（冬季）");
        int mouth = cs.nextInt();
        switch (mouth){
            //case 穿透
            case 1:
            case 2:
            case 3:
                System.out.println("春季");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("夏季");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("秋季");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("冬季");
                break;
            default:
                System.out.println("输入数据错误");
                break;
        }
    }
}