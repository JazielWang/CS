package com.Queue;

import java.util.Scanner;

public class ArrayQueueDmeo {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(3);
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        char key = ' ';
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = sc.next().charAt(0);
            switch (key) {
                case 's':
                    aq.show();
                    break;
                case 'a':
                    System.out.println("请输入一个值：");
                    int i = sc.nextInt();
                    aq.put(i);
                    break;
                case 'g':
                    try {
                        int ii = aq.get();
                        System.out.println("数据是：" + ii);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int iii = aq.head();
                        System.out.println("头部数据时：" + iii);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
