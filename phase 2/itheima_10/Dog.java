package com.itheima_10;

public class Dog extends Animal{
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public void eat() {
        System.out.println("dog eat bone");
    }

    @Override
    public void jump() {
        System.out.println("dog don't jump very tall");
    }
}
