package com.itheima06;

import java.io.File;

public class FileDemo01 {
    public static void main(String[] args) {
        File f1 = new File("E:\\Google\\java.txt");
        System.out.println(f1);

        File f2 = new File("E:\\Google","java.txt");
        System.out.println(f2);

        File f3 = new File("E:\\Google");
        File f4 = new File(f3, "java.txt");
        System.out.println(f4);
    }
}
