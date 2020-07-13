package com.itheima_02;

/*    测试类   */

public class AnimalDemo {
    public static void main(String[] args) {
        // 创建动物操作类的方法，调用方法
        AnimalOperator a = new AnimalOperator();
        Cat c = new Cat();
        a.useAnimal(c);

        Dog d = new Dog();
        a.useAnimal(d);
//        a.lookDoor();
    }
}
