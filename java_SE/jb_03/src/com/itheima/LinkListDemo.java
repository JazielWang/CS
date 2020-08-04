package com.itheima;

import java.util.LinkedList;

public class LinkListDemo {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();

        ll.add("hello");
        ll.add("world");
        ll.add("java");

        ll.addFirst("javaee");
        ll.addLast("javaee");

        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());

        System.out.println(ll.removeFirst());
        System.out.println(ll.removeLast());

        System.out.println(ll);
    }
}
