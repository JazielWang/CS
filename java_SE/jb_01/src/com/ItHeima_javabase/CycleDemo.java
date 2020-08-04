package com.ItHeima_javabase;

public class CycleDemo {
    public static void main(String[] args) {

        //使用 for 循环语句
        for (int i = 1; i <=5; i++){
            System.out.println("HelloWorld");
        }
        // for 循环的案例
        for (int i = 1; i <= 5; i++){
            System.out.println(i);
        }
        for (int i = 100; i > 0; i--){
            System.out.println(i);
        }

        // for循环 求和实例
        int sum = 0;
        for (int i = 1; i <= 5; i++){
            sum += i;
        }
        System.out.println(sum);

        // for循环 求偶数和
        int sum2 = 0;
        for (int i = 1; i <=100; i++){
            if (i % 2 == 0){
                sum2 += i;
            }
        }
        System.out.println(sum2);

        //for循环输出水仙花数
        for (int i = 100; i <= 999; i++){
            int a = i % 10;
            int b = i / 10 % 10;
            int c = i / 100;
            if (a*a*a + b*b*b + c*c*c == i){
                System.out.println(i + "是水仙花数");
            }
        }

        // for循环，统计水仙花数个数
        int count = 0;
        for (int i = 100; i <= 999; i++){
            int a = i % 10;
            int b = i / 10 % 10;
            int c = i / 100;
            if (a*a*a + b*b*b + c*c*c == i){
                count++;
            }
        }
        System.out.println("三位数水仙花数有：" + count);


        // while 循环语句
        for (int i = 1; i <= 5; i++){
            System.out.println("HelloWorld");
        }
        int j = 1;
        while (j <= 5){
            System.out.println("HelloWorld");
            j++;
        }
        // while 案例：珠穆朗玛峰
        int s = 0;
        double k = 0.1;
        while (k <=8844430){
            k *= 2;
            s++;
        }
        System.out.println(s);


        // do......while 循环语句
        int b = 1;
        do {
            System.out.println("helloWorld");
            b++;
        }while (b <= 5);
    }
}
