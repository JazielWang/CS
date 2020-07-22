package com.itheima06;

import java.io.File;

public class FileDemo03 {
    public static void main(String[] args) {
        File f = new File("java.txt");

        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println(f.exists());

        System.out.println(f.getAbsoluteFile());
        System.out.println(f.getPath());
        System.out.println(f.getName());

        File f2 = new File("E:\\Google");
        String[] list = f2.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = f2.listFiles();
        for (File file : files){
//            System.out.println(file);
//            System.out.println(file.getName());
            if (file.isFile()){
                System.out.println(file.getName());
            }
        }
    }
}
