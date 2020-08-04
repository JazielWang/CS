package com.itheima_19;

public class SystemDemo {
    public static void main(String[] args) {
        System.out.println("start");

        System.out.println(System.currentTimeMillis() * 1.0 / 1000 / 60 / 60 / 24 / 365);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        System.exit(0);

        System.out.println("end");
    }
}
