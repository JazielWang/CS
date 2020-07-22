package com.itheima_12;

public class CatDemo {
    public static void main(String[] args) {
        CatOperator co = new CatOperator();
        Cat c = new Cat();
        co.useCat(c);

        Cat c2 = co.getCat();
        c2.eat();

    }
}
