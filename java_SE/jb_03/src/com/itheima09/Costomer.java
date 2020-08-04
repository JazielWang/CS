package com.itheima09;

public class Costomer implements Runnable {
    private Box b;

    public Costomer(Box b) {
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            b.get();
        }
    }
}
