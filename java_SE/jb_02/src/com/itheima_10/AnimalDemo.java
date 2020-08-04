package com.itheima_10;


public class AnimalDemo {
    public static void main(String[] args) {
        // 创建对象，调用方法
        Jumpping j = new Cat();
        j.jump();
        // 创建猫类对象进行测试
        Animal a = new Cat();
        a.setName("加菲");
        a.setAge(25);
        System.out.println(a.getName() + "," + a.getAge());
        a.eat();

        a = new Cat("比利", 25);
        System.out.println(a.getName() + "," + a.getAge());
        a.eat();

        // 在实际的使用中使用这种方法，因为它可以调用所有的方法，而不需要分别调用
        Cat c = new Cat();
        c.setName("加菲");
        c.setAge(15);
        System.out.println(c.getName() + "," + c.getAge());
        c.eat();
        c.jump();


        // 创建狗类对象进行测试
        a = new Dog();
        a.setName("旺财");
        a.setAge(12);
        System.out.println(a.getName() + "," + a.getAge());
        a.eat();

        a = new Dog("豆豆" , 12);
        System.out.println(a.getName() + "," + a.getAge());
        a.eat();

        // 狗的
        Dog d = new Dog();
        d.setName("bili");
        d.setAge(12);
        System.out.println(d.getName()+","+d.getAge());
        d.eat();
        d.jump();
    }
}
