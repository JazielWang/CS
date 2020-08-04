package com.ithiema_01;
/*
    Lambda表达式的格式：(形式参数) -> {代码块}

    练习2：
        1:定义一个接口(Flyable)，里面定义一个抽象方法：void fly(String s);
        2:定义一个测试类(FlyableDemo)，在测试类中提供两个方法
            一个方法是：useFlyable(Flyable f)
            一个方法是主方法，在主方法中调用useFlyable方法
 */
public class FlyDemo {
    public static void main(String[] args) {
        Flyable f = new FlyableImp();
        useFlyable(f);

        useFlyable(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s + "I believe I can fly");
            }
        });

        useFlyable((String s) -> {
            System.out.println(s + "I believe I can fly");
        });
    }

    public static void useFlyable(Flyable f) {
        f.fly("sun");
    }
}
