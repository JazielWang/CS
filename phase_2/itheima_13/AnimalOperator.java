package com.itheima_13;

public class AnimalOperator {
    public static void main(String[] args) {
        AnimalDemo ad = new AnimalDemo();
        Animal a = new Cat();
        ad.useAnimal(a);


        Animal animal = ad.getAnimal();
        animal.eat();

    }
}
