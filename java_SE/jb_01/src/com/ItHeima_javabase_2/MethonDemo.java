package com.ItHeima_javabase_2;

public class MethonDemo {
    public static void main(String[] args) {
        isEvenNumber();
        getMax();
        // 带常量值方法的调用
        isEvenNumber2(10);
        // 带变量方法的调用
        int num = 10;
        isEvenNumber2(num);

        Max(12, 56);
        int a = 10;
        int b = 56;
        Max(a, b);

        // 带返回值方法的调用
//        isEvenNumber(10);
        boolean num2 = isEvenNumber(10);
        System.out.println(num2);

        int num3 = getMax(15, 46);
        System.out.println(num3);
        System.out.println(getMax(10, 20));

        // 方法重载的调用(java 虚拟机会根据调用方法数据类型调用不同的方法)
        int reslut = sum(45, 23);
        System.out.println(reslut);
        double res = sum(20.0, 12.0);
        System.out.println(res);
        int resl = sum(12, 25, 46);
        System.out.println(resl);

        // 方法参数传递类型的调用
        int num6 = 100;
        System.out.println(num6);
        charge(num6);
        System.out.println(num6);
        int[] arr = {10, 20, 30};
        System.out.println(arr[1]);
        charges(arr);
        System.out.println(arr[1]);

        // 数组遍历调用
        int[] arr2 = {11, 22, 33, 44, 55};
        printArr(arr2);
        // 数组取最大值调用
        int max = maxArr(arr2);
        System.out.println(max);
    }






    // 定义一个方法，在方法中定义一个变量，判断该数据是否是偶数
    public static void isEvenNumber(){
        int num = 10;
        if (num % 2 == 0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
    public static void getMax(){
        int a = 10;
        int b = 20;
        if (a > b){
            System.out.println(a);
        }else{
            System.out.println(b);
        }
    }

    // 带参数方法和其调用
    public static void isEvenNumber2(int num){
        if (num % 2 == 0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

    public static void Max(int c, int d){
        if (c > d){
            System.out.println(c);
        }else{
            System.out.println(d);
        }
    }

    // 带返回值方法的定义
    public static boolean isEvenNumber(int num){
        if(num%2 == 0){
            return true;
        }else{
            return false;
        }
    }

    public static int getMax(int a, int b){
        if (a > b){
            return a;
        }else {
            return b;
        }
    }

    // 方法重载
    public static int sum(int a, int b){
        return a + b;
    }
    public static double sum(double a, double b){
        return a + b;
    }
    public static int sum(int a, int b, int c){
        return  a + b + c;
    }

    // 方法参数传递
    public static void charge(int num6){
        num6 = 200;
    }
    public static void charges(int[] arr){
        arr[1] = 100;
    }

    // 对一个数组进行遍历
    public static void printArr(int[] arr){
        System.out.print("[");
        for (int x = 0; x <arr.length; x++){
            if (x == arr.length -1){
                System.out.print(arr[x]);
            }else {
                System.out.print(arr[x] + ", ");
            }

        }
        System.out.println("]");
    }

    // 对一个数组取最大值
    public static int maxArr(int[] arr){
        int max = arr[0];
        for (int x = 1; x < arr.length; x++){
            if (arr[x] > max){
                max = arr[x];
            }
        }
        return max;
    }
}

