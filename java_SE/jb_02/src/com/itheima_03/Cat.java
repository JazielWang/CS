package com.itheima_03;
/*      猫类      */
public class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
    public void playGame(){
        System.out.println("猫爱捉迷藏");
    }
}
