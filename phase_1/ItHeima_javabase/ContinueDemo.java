package com.ItHeima_javabase;
import java.util.Random;
import java.util.Scanner;
public class ContinueDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++){
            if (i % 2 == 0){
                //continue;
                break;
            }
            System.out.println(i);
        }


        // 循环嵌套
        for (int i = 0; i <= 3; i++){
            for (int j = 0; j <= 3; j++){
                System.out.println(i + "hours" + j + "minus");
            }
        }


        // Random 使用
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int num = r.nextInt(10);
        System.out.println(num);

        // 需求；获取一个 1-100 之间的数字
        int num2 = r.nextInt(100) + 1;
        System.out.println(num2);

        // Random 案例 ：猜数字
        int num3 = r.nextInt(100) + 1;
        for (int i = 10; i >= 1; i--){
            System.out.println("请输入一个数字（1-100），你只有" + i + "次机会");
            int num4 = sc.nextInt();
            if (num4 < 1 || num3 > 100){
                System.out.println("你输入的数据有误");
            }else if (num4 == num3){
                System.out.println("你猜对啦，数字就是：" + num3);
                break;
            }else if (num4 > num3){
                System.out.println("你的数字太大了");
            }else {
                System.out.println("你的数字太小了");
            }
        }
    }
}
