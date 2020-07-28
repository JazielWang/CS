package com.itheima09;

public class SellTicketDemo02 {
    public static void main(String[] args) {
        SellTicket02 st = new SellTicket02();

        Thread t1 = new Thread(st,"售票口1");
        Thread t2 = new Thread(st,"售票口2");
        Thread t3 = new Thread(st,"售票口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
