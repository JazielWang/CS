package com.ithiema_01;

public class FlyableImp implements Flyable {
    @Override
    public void fly(String s) {
        System.out.println(s + "I believe I can fly");
    }
}
