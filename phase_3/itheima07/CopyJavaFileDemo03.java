package com.itheima07;

import java.io.*;
/*
    需求：
        把模块目录下的ConversionStreamDemo.java 复制到模块目录下的 Copy.java

    思路：
        1:根据数据源创建字符缓冲输入流对象
        2:根据目的地创建字符缓冲输出流对象
        3:读写数据，复制文件
            使用字符缓冲流特有功能实现
        4:释放资源
 */
public class CopyJavaFileDemo03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\Google\\OutputStreamWriterDemo.java"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Google\\Dark\\copy.java"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
