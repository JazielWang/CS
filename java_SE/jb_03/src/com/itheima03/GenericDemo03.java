package com.itheima03;

public class GenericDemo03 {
    public static void main(String[] args) {
        Generic03<String> g1 = new GeneericImpl<>();
        g1.show("王杰");
        Generic03<Integer> g2 = new GeneericImpl<>();
        g2.show(12);
        Generic03<Boolean> g3 = new GeneericImpl<>();
        g3.show(true);
    }
}
