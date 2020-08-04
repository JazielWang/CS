package com.itheima06;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInpuStreamDemo01 {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("E:\\Google\\java.txt");

        /*int by = fis.read();
        System.out.println(by);
        System.out.println((char)by);
        by = fis.read();
        System.out.println(by);
        System.out.println((char)by);
        by = fis.read();
        System.out.println(by);
        by = fis.read();
        System.out.println(by);*/

        /*int by = fis.read();
        while (by != -1){
            System.out.print((char)by);
            by = fis.read();
        }*/

        // 优化程序
        int by;
        while ((by = fis.read()) != -1) {
            System.out.print((char) by);
        }

        fis.close();
    }
}
