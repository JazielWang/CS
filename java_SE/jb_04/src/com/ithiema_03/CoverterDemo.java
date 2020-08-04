package com.ithiema_03;
/*
    练习：
        1:定义一个接口(Converter)，里面定义一个抽象方法：
            int convert(String s);
        2:定义一个测试类(ConverterDemo)，在测试类中提供两个方法
            一个方法是：useConverter(Converter c)
            一个方法是主方法，在主方法中调用useConverter方法
 */
public class CoverterDemo {
    public static void main(String[] args) {
        //在主方法中调用useConverter方法

//        useConverter((String s) -> {
//            return Integer.parseInt(s);
//        });

        useCoverter(s -> Integer.parseInt(s));

        useCoverter(Integer::parseInt);
        //Lambda表达式被类方法替代的时候，它的形式参数全部传递给静态方法作为参数
    }

    private static void useCoverter(Coverter c){
        int i = c.charge("666");
        System.out.println(i);
    }
}
