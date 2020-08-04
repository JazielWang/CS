package com.ithiema_01;
/*
    Lambda表达式的格式：(形式参数) -> {代码块}

    练习3：
        1:定义一个接口(Addable)，里面定义一个抽象方法：int add(int x,int y);
        2:定义一个测试类(AddableDemo)，在测试类中提供两个方法
            一个方法是：useAddable(Addable a)
            一个方法是主方法，在主方法中调用useAddable方法
 */
public class AddableDemo {
    public static void main(String[] args) {
        useAddable(new Addable() {
            @Override
            public int add(int a, int b) {
                int usm = a + b;
                return usm;
            }
        });

        useAddable((int x, int y) -> {
            return x + y;
        });
    }

    private static void useAddable(Addable a) {
        int sum = a.add(10, 23);
        System.out.println(sum);
    }
}
