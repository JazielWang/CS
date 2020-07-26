package com.itheima07;

import java.io.*;

public class BufferedStreamDemo01 {
    public static void main(String[] args) throws IOException {
        //
//        FileWriter fw = new FileWriter("E:\\Google\\java.txt");
//        BufferedWriter bw = new BufferedWriter(fw);
        /*BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Google\\java.txt"));

        bw.write("hello");
        bw.write("world");

        bw.close();*/

        BufferedReader br = new BufferedReader(new FileReader("E:\\Google\\java.txt"));

        // 一次读取一个字符数据
        /*int by;
        while ((by = br.read()) != -1) {
            System.out.print((char) by);
        }*/

        // 一次读取在一个字符数组数据
        char[] chs = new char[1024];
        int len;
        while ((len=br.read(chs))!=-1){
            System.out.print(new String(chs,0,len));
        }

        br.close();
    }
}
