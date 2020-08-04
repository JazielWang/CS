package com.itheima;

import javax.swing.plaf.BorderUIResource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo03 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();

        c.add("hello");
        c.add("world");
        c.add("java");

        Iterator<String> it = c.iterator();
        /*System.out.println(it.next());
        System.out.println(it.next());*/

        /*for (;;) {
            if (it.hasNext()) {
//                System.out.println(it.next());
                String s = it.next();
                System.out.println(s);
            }else {
                break;
            }
        }*/

        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
    }
}
