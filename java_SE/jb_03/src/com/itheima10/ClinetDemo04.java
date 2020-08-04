package com.itheima10;

import java.io.*;
import java.net.Socket;
/*
    客户端：数据来自于文本文件
 */
public class ClinetDemo04 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("10.171.77.101",10000);
        //封装文本文件的数据
        BufferedReader br = new BufferedReader(new FileReader("E:\\Google\\wxb.txt"));
        //封装输出流写数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line=br.readLine())!=null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        br.close();
        s.close();
    }
}
