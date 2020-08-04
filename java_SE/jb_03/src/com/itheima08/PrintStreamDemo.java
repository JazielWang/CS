package com.itheima08;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
/*
    字符打印流的构造方法：
        PrintWriter​(String fileName) ：使用指定的文件名创建一个新的PrintWriter，而不需要自动执行行刷新

        PrintWriter​(Writer out, boolean autoFlush)：创建一个新的PrintWriter
            out：字符输出流
            autoFlush： 一个布尔值，如果为真，则println ， printf ，或format方法将刷新输出缓冲区
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("E:\\Google\\java4.txt");

        ps.write(97);
        ps.println();
        ps.println(97);
        ps.println(98);

        ps.close();
    }
}
