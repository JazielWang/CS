package com.itheima10;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/*
    客户端：数据来自于键盘录入，直到输入的数据是886，发送数据结束
 */
public class ClinetDemo02 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("10.181.152.90",10000);

        //数据来自于键盘录入，直到输入的数据是886，发送数据结束
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //封装输出流对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String data;

        while ((data=br.readLine())!=null) {
            if ("886".equals(data)){
                break;
            }
            //获取输出流对象
//            OutputStream os = s.getOutputStream();
//            os.write(line.getBytes());
            bw.write(data);
            bw.newLine();
            bw.flush();
        }
        s.close();
    }
}
