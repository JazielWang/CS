package com.itheima_18;

public class JumppingDemo {
    public static void main(String[] args) {
        JumppingOperator jo = new JumppingOperator();
        Jumpping j = new Cat();
        jo.useJumpping(j);
        System.out.println("--------------");

        jo.useJumpping(new Jumpping(){
            @Override
            public void jump() {
                System.out.println("cat can jump now");
            }
        });
    }
}
