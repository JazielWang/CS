package com.itheima_04;
/*      测试类     */
public class AnimalDemo {
    public static void main(String[] args) {
        // 创建猫类对象进行测试
        Animal a = new Cat();
        a.setName("加菲");
        a.setAge(25);
        System.out.println(a.getName() + "," + a.getAge());
        a.eat();

        a = new Cat("比利", 25);
        System.out.println(a.getName() + "," + a.getAge());
        a.eat();


        // 创建狗类对象进行测试
        a = new Dog();
        a.setName("旺财");
        a.setAge(12);
        System.out.println(a.getName() + "," + a.getAge());
        a.eat();

        a = new Dog("豆豆" , 12);
        System.out.println(a.getName() + "," + a.getAge());
        a.eat();
    }
}
