package com.itheima08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
/*
    需求：
        把模块目录下的PrintStreamDemo.java 复制到模块目录下的 Copy.java

    思路：
        1:根据数据源创建字符输入流对象
        2:根据目的地创建字符输出流对象
        3:读写数据，复制文件
        4:释放资源
 */
public class PrintCopyFile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\Google\\OutputStreamWriterDemo.java"));
        PrintWriter pw = new PrintWriter("E:\\Google\\printfile.java");

        String len;
        while ((len = br.readLine())!=null){
            pw.println(len);
        }

        br.close();
        pw.close();
    }
}
