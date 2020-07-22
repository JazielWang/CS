package com.itheima06;

import java.io.*;

public class BufferStreamDemo {
    public static void main(String[] args) throws IOException {
        // 字符缓冲输出流
//        FileOutputStream fos = new FileOutputStream("E:\\Google\\java.txt");
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
        /*BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\Google\\java.txt"));
        bos.write("hello\r\n".getBytes());
        bos.write("world\r\n".getBytes());
        bos.close();*/

        // 字节缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\Google\\java.txt"));

        // 一次读取一个字节数据
        /*int by;
        while ((by = bis.read()) != -1){
            System.out.print((char)by);
        }*/
        // 一次读取一个字节数组数据
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys))!=-1){
            System.out.println(new String(bys,0,len));
        }

        bis.close();
    }
}
