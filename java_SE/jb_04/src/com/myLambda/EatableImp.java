package com.ithiema_01;

public class EatableImp implements Eatable{
    @Override
    public void eat() {
        System.out.println("一天一苹果，医生远离我");
    }
}
