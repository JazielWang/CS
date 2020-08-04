package com.itheima06;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("E:\\Google\\java.txt");

        //void write​(int b)：将指定的字节写入此文件输出流
        fos.write(79);

        // void write​(byte[] b)：将 b.length字节从指定的字节数组写入此文件输出流
//        byte[] bys = {12,24,25,46};
        byte[] bys = "abcde".getBytes();
//        fos.write(bys);

        // //void write​(byte[] b, int off, int len)：将 len字节从指定的字节数组开始，从偏移量off开始写入此文件输出流
        fos.write(bys,1,bys.length-1);



        fos.close();
    }
}
