package com.itheima07;

import java.io.*;

public class CopyjavaFileDemo02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\Google\\OutputStreamWriterDemo.java"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Google\\Dark\\write.java"));

        // 一次读入一个字符数据
        /*int by;
        while ((by = br.read())!=-1){
            bw.write(by);
        }*/

        // 一次读入一个字符数组数据
        char[] chs = new char[1024];
        int len;
        while ((len=br.read(chs))!=-1){
            bw.write(chs,0,len);
        }

        br.close();
        bw.close();
    }
}
