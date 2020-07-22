package com.itheima06;

import java.io.File;
import java.io.IOException;

public class FileDemo04 {
    public static void main(String[] args) throws IOException {
//        File f = new File("E:\\Google\\java.txt");
        // 需求1： 在当前模块目录下创建java.txt 文件
        File f = new File("src\\java.txt");
//        System.out.println(f.createNewFile());

        // 需求2：删除当前目录下的java.txt 文件
        System.out.println(f.delete());
        System.out.println("------------");

        // 需求3：在当前模块目录下创建itcast目录
        File f2 = new File("src\\itcast");
//        System.out.println(f2.mkdir());

        // 需求4：删除当前目录下的itcast目录
        System.out.println(f2.delete());
        System.out.println("------------");

        // 需求5：在当前模块下创建一个目录itcast，并在该目录下常见一个文件java.txt
        File f3 = new File("src\\itcast");
//        System.out.println(f3.mkdir());
        File f4 = new File("src\\itcast\\java.txt");
//        System.out.println(f4.createNewFile());

        // 需求6：删除当前模块下的目录itcas
        // 要删除存在文件的目录，需要先将目录中的文件删除
        System.out.println(f4.delete());
        System.out.println(f3.delete());
    }
}
