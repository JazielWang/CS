package com.ithiema_03;
/*
    需求：
        1:定义一个接口(Printable)：里面定义一个抽象方法：void printInt(int i);
        2:定义一个测试类(PrintableDemo)，在测试类中提供两个方法
            一个方法是：usePrintable(Printable p)
            一个方法是主方法，在主方法中调用usePrintable方法
 */
public class PrintableDemo02 {
    public static void main(String[] args) {
        //在主方法中调用usePrintable方法
        usePrintable02(i -> System.out.println(i));

        //方法引用
        usePrintable02(System.out::println);
    }

    private static void usePrintable02(Printable02 p){
        p.method(256);
    }
}
