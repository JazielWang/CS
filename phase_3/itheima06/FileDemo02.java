package com.itheima06;

import java.io.File;
import java.io.IOException;

public class FileDemo02 {
    public static void main(String[] args) throws IOException {
        // 如果创建文件/目录不存在，就创建，并返回true；否则就不创建文件，并返回false

        File f1 = new File("E:\\Google\\java.txt");
        System.out.println(f1.createNewFile());
        System.out.println("----------------");

        File f2 = new File("E:\\Google\\java");
        System.out.println(f2.mkdir());
        System.out.println("----------------");

        File f3 = new File("E:\\Google\\javaSE\\HTLM");
        System.out.println(f3.mkdirs());
        System.out.println("---------------");

        File f4 = new File("E:\\Google\\javaee.txt");
        System.out.println(f4.mkdir());

    }
}
