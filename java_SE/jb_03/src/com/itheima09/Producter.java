package com.itheima09;

public class Producter implements Runnable {

    private Box b;

    public Producter(Box b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            b.put(i);
        }
    }
}
