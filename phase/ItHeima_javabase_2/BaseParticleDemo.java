package com.ItHeima_javabase_2;

/*
对之前学习的分支语句、控制语句、数组、方法进行再次练习，加深印象
*/

import java.util.Scanner;

public class BaseParticleDemo {
    public static void main(String[] args) {

        // 减肥计划 - if
        Scanner cs = new Scanner(System.in);
        System.out.println("减肥计划 - 请输入一个星期数（1-7）：");
        int week = cs.nextInt();
        if (week > 7 || week < 1) {
            System.out.println("输入数据有误");
        } else if (week == 1) {
            System.out.println("星期一：跑步");
        } else if (week == 2) {
            System.out.println("星期二：游泳");
        } else if (week == 3) {
            System.out.println("星期三：慢走");
        } else if (week == 4) {
            System.out.println("星期四：动感单车");
        } else if (week == 5) {
            System.out.println("星期五：拳击");
        } else if (week == 6) {
            System.out.println("星期六：爬山");
        } else {
            System.out.println("星期天：好好吃一顿");
        }

        // 减肥计划 - swith
        System.out.println("减肥计划 - 请输入一个星期数（1-7）：");
        int week2 = cs.nextInt();
        switch (week2) {
            case 1:
                System.out.println("跑步");
                break;
            case 2:
                System.out.println("swimming");
                break;
            case 3:
                System.out.println("flogging");
                break;
            case 4:
                System.out.println("bike");
                break;
            case 5:
                System.out.println("拳击");
                break;
            case 6:
                System.out.println("爬山");
                break;
            case 7:
                System.out.println("好好吃一顿");
                break;
            default:
                System.out.println("输入数据有误");
        }

        // 逢七过 for + if
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0 || i / 10 == 7 || i % 10 == 7) {
                System.out.println(i);
            }
        }

        // 不死神兔 arry+for
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[19]);

        //百钱百鸡 for+if
        // 第1层循环，用于表示鸡翁的范围，初始化表达式的变量定义为 x=0，判断条件是 x<=20
        for (int x = 0; x <= 20; x++) {
            // 第2层循环，用于表示鸡母的范围，初始化表达式的变量定义为 y=0，判断条件是 y<=33
            for (int y = 0; y <= 33; y++) {
                // 这个时候，用于表达鸡雏的变量 z=100-x-y
                int z = 100 - x - y;
                // 判断表达式 z%3==0 和表达式 5*x+y*3+z/3==100 是否同时成立
                if (z % 3 == 0 && 5 * x + 3 * y + z / 3 == 100) {
                    System.out.println(x + "," + y + "," + z);
                }
            }
        }

        // 数组元素求和 for+if+arry
        int[] arr2 = {68, 27, 95, 88, 171, 996, 51, 210};

        int sum = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] % 2 == 0 && arr2[i] % 10 != 7 && arr2[i] / 10 % 10 != 7) {
                sum += arr2[i];
            }
        }
        System.out.println(sum);

        // 数组内容相同的调用
        int[] arr3 = {12, 38, 27, 39, 49, 28, 69};
        int[] arr4 = {12, 38, 27, 39, 49, 28};
        boolean resl = tactArr(arr3, arr4);
        System.out.println(resl);

        // 查找 调用
        int[] arr5 = {23, 34, 34, 53, 64, 86, 10};
        System.out.println("请输入一个数字：");
        int num = cs.nextInt();
        int x = findArr(arr5, num);
        System.out.println("寻找数字对应编号是：" + x);

        // 反转调用
        int[] arr6 = {45, 23, 35, 46, 57, 90, 92};
        getVerse(arr6);
        getVerse2(arr6);

        // 评委打分
        int[] arr7 = new int[7];
        for (int i = 0; i < arr7.length; i++){
            System.out.println("请输入第" + (i + 1) +"个评委的打分：");
            arr7[i] = cs.nextInt();
        }
        int avg = ver(arr7);
        System.out.println(avg);






    }


    //数组内容相同的调用
    public static boolean tactArr(int[] arr, int[] arr2) {
        if (arr.length == arr2.length) {
            for (int x = 0; x < arr.length; x++) {
                for (int y = 0; y < arr2.length; y++) {
                    if (arr[x] == arr2[y]) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    //    查找方法
    public static int findArr(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    //反转方法 - 1
    public static void getVerse(int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[arr.length - 1 - i];
        }
        arr = arr2;
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }

    // 反转方法 - 2
    public static void getVerse2(int[] arr) {
        for (int start = 0, end = arr.length - 1; start <= end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }

    // 评委打分方法
    public static int ver(int[] arr) {
        int max2 = arr[0];
        int min2 = arr[0];
        int sum2 = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max2) {
                max2 = arr[i];
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min2) {
                min2 = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            sum2 += arr[i];
        }
        int aver = (sum2 - max2 - min2) / (arr.length - 2);
        return aver;
    }

}


